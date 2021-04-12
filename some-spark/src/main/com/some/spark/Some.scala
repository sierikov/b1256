package com.some.spark

import org.apache.spark.sql.{Dataset, Row}
import org.apache.spark.sql.SparkSession

object Main {
  def main(): Unit = {
    val spark = SparkSession.builder().getOrCreate()
    spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "myKafkaBootStrapServer:9092")
      .option("subscribe", "myMagicTopic")
      .option("checkpointLocation", "/some/where/on/my/disk/")
      .load()
      .selectExpr(
        "timestamp",
        "CAST(value AS STRING) AS value"
      )
      .writeStream
      .foreachBatch { (data: Dataset[Row], batchId: Long) => }
      .start()
      .awaitTermination()
  }
}
