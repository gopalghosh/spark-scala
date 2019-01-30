package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object MaxValue {
   
  def main(args:Array[String]){
      val conf =new SparkConf().setMaster("local").setAppName("SparkScala")
    val sparkContext=new SparkContext(conf)
    val tweet = sparkContext.textFile("/home/gopal/ScalaWork/test.txt").mapPartitionsWithIndex( (idx, row) => if(idx==0) row.drop(1) else row )
    //tweet.foreach(x=>println(">>>>>>>>>>>>>"+x))
    val MaxTweetId = tweet.map(x => (x.split(",")(2).toInt,x)).reduceByKey((x,y) => if(x>y) x else y)       
     val MinTweetId = tweet.map(x => (x.split(",")(2).toInt,x)).reduceByKey((x,y) => if(x>y) y else x)
    println(">>>>>>>>")
     MinTweetId.collect().foreach(x=>println(">>>>>>>>>>>>>"+x))
     sparkContext.stop();
     
  }
}