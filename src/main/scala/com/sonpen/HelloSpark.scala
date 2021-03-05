package com.sonpen

import org.apache.spark.sql.SparkSession

object HelloSpark extends App{
  val spark = SparkSession.builder().appName("HelloSpark").master("local[*]").getOrCreate()

  val rdd = spark.sparkContext.textFile("/Users/1109806/apps/spark/LICENSE")

  println(s"line count: ${rdd.count()}")

}
