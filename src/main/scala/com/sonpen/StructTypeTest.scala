package com.sonpen

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Encoders

case class Person(name: String, age:Int)
object StructTypeTest extends App{
  val spark = SparkSession.builder()
    .appName(this.getClass.getName)
    .master("local[*]")
    .getOrCreate()

  val df = spark.read.schema(Encoders.product[Person].schema).csv("/Users/user/a.txt")

  df.printSchema()
}
