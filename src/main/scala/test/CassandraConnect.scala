package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import com.datastax.spark.connector._

object CassandraConnect {
  
  def main(args:Array[String]){
    val conf=new SparkConf().setMaster("local").setAppName("SparkScala").set("spark.cassandra.connection.host", "localhost")//.set(DefaultAuthConfFactory.UserNameParam.name, "rsomani").set(DefaultAuthConfFactory.PasswordParam.name, "ramsomani")
    val sc=new SparkContext(conf)
    val rdd=sc.cassandraTable("sparkdata","words")
    rdd.foreach(println)
    //val rdd1=rdd.map(row => row.getInt("lastname"))
    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+rdd.first())
  }
}