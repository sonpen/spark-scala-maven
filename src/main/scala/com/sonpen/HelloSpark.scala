package com.sonpen

import org.apache.spark.sql.SparkSession

object HelloSpark extends App{
  val spark = SparkSession.builder().appName("HelloSpark").master("local[*]").getOrCreate()

  /*
  val rdd = spark.sparkContext.textFile("/Users/user/a.txt")

  println(s"line count: ${rdd.count()}")
   */

  val jsonStr = """{ "metadata": { "key": 84896, "value": 54 }}"""
  val rdd = spark.sparkContext.parallelize(Seq(jsonStr))
  val df = spark.sqlContext.read.json(rdd)

  df.printSchema()

}
