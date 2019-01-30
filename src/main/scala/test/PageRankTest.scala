package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.HashPartitioner

object PageRankTest {
  
  def main(argd:Array[String]){
    val conf=new SparkConf().setMaster("local").setAppName("SparkScala")
    val sprCtx=new SparkContext(conf)
    val links=sprCtx.objectFile[(String, Seq[String])]("links").partitionBy(new HashPartitioner(100)).persist()
    var ranks=links.mapValues(v=>1.0)
    for(1 <-0 until 10){
      val contributions=links.join(ranks).flatMap{
        case (pageId, (links,rank))=>links.map(dest=>(dest,rank/links.size))
      }
      ranks=contributions.reduceByKey((x, y) => x+y).mapValues(v => 0.15+0.85*v)
    }
    ranks.saveAsTextFile("/home/gopal/ScalaWork/ranks1")
  }
}