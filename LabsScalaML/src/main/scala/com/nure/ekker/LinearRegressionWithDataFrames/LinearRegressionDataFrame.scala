package com.nure.ekker.LinearRegressionWithDataFrames

import org.apache.log4j._
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql._

object LinearRegressionDataFrame {


  /** Our main function where the action happens */
  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = SparkSession
      .builder
      .appName("LinearRegressionDFEkker")
      .master("local[*]")
      .config("spark.sql.warehouse.dir", "file:///C:/temp")
      .getOrCreate()

    val inputLines = spark.sparkContext.textFile(
      "src/main/resources/regression.txt")

    val data = inputLines.map(_.split(",")).map(
      x => (x(0).toDouble, Vectors.dense(x(1).toDouble)))

    import spark.implicits._
    val colNames = Seq("label", "features")
    val df = data.toDF(colNames: _*)

    val trainTest = df.randomSplit(Array(0.5, 0.5))
    val trainingDF = trainTest(0)
    val testDF = trainTest(1)

    val lir = new LinearRegression()
      .setRegParam(0.3) // параметр регуляризации
      .setElasticNetParam(0.8) // смешивание эластичной сетки
      .setMaxIter(200) // кол-во итераций
      .setTol(1E-6) // параметр допуска сходимости

    val model = lir.fit(trainingDF)

    val fullPredictions = model.transform(testDF).cache()

    val predictionAndLabel = fullPredictions
      .select("prediction", "label")
      .rdd.map(x => (x.getDouble(0), x.getDouble(1)))

    for (prediction <- predictionAndLabel) {
      println(prediction)
    }
    spark.stop()
  }
}
