package com.nure.ekker.LinearRegression

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.mllib.optimization.SquaredL2Updater
import org.apache.spark.mllib.regression.{LabeledPoint, LinearRegressionWithSGD}

object LinearRegression {

  /** Our main function where the action happens */
  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val sc = new SparkContext("local[*]", "LinearRegressionEkkerLab")

    val trainingLines = sc.textFile("src/main/resources/regression.txt")
    val testingLines = sc.textFile("src/main/resources/regression.txt")

    val trainingData = trainingLines.map(LabeledPoint.parse).cache()
    val testData = testingLines.map(LabeledPoint.parse)

    val algorithm = new LinearRegressionWithSGD()
    algorithm.optimizer
      .setNumIterations(100)
      .setStepSize(1.0)
      .setUpdater(new SquaredL2Updater())
      .setRegParam(0.01)

    val model = algorithm.run(trainingData)

    val predictions = model.predict(testData.map(_.features))

    val predictionAndLabel = predictions.zip(testData.map(_.label))
    for (prediction <- predictionAndLabel) {
      println(prediction)
    }
  }
}
