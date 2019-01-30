package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext

object TestDataFrame {
  
  def main(args : Array[String]):Unit={
    val conf=new SparkConf().setMaster("local").setAppName("SparkScala")
    val sprCtx=new SparkContext(conf)
    val sqlCtx=new SQLContext(sprCtx)
    
    val df=sqlCtx.read.format("csv").option("header", "true").load("/home/gopal/ScalaWork/input1.csv")
   // df.select($"col1").orderBy($"col1".desc).limit(3).show()
   df.select("tc").where(df.col("tc")>30).orderBy("tc").show()
   //df.repartition(partitionExprs)
   //df.groupBy("tc")
    //df.show()
    //df.to
    
  }
}