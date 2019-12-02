package com.nure.ekker.AlternatingLeastSquares

import java.nio.charset.CodingErrorAction

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.mllib.recommendation.{ALS, Rating}

import scala.io.{Codec, Source}

object MovieRecommendationsALS {

  /** Load up a Map of movie IDs to movie names. */
  def loadMovieNames(): Map[Int, String] = {

    implicit val codec: Codec = Codec("UTF-8")
    codec.onMalformedInput(CodingErrorAction.REPLACE)
    codec.onUnmappableCharacter(CodingErrorAction.REPLACE)

    var movieNames: Map[Int, String] = Map()

    val lines = Source.fromFile("src/main/resources/u.item").getLines()
    for (line <- lines) {
      val fields = line.split('|')
      if (fields.length > 1) {
        movieNames += (fields(0).toInt -> fields(1))
      }
    }
    movieNames
  }

  /** Our main function where the action happens */
  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "MovieRecommendationsALSEkker")

    println("Loading movie names...")
    val nameDict = loadMovieNames()

    val data = sc.textFile("src/main/resources/u.data")

    val ratings = data.map(x => x.split('\t')).map(
      x => Rating(x(0).toInt, x(1).toInt, x(2).toDouble)).cache()

    println("\nTraining recommendation model...")

    val rank = 8
    val numIterations = 20

    val model = ALS.train(ratings, rank, numIterations)

    val userID = 0 //рекомендации для пользователя с каким id мы хотим

    println("\nRatings for user ID " + userID + ":")

    val userRatings = ratings.filter(x => x.user == userID)

    val myRatings = userRatings.collect()

    for (rating <- myRatings) {
      println(nameDict(rating.product.toInt) + ": " + rating.rating.toString)
    }

    println("\nTop 10 recommendations:")

    val recommendations = model.recommendProducts(userID, 10)
    for (recommendation <- recommendations) {
      println(nameDict(recommendation.product.toInt) + " score " + recommendation.rating)
    }

  }
}
