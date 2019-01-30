package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import org.apache.spark.HashPartitioner

object PairRdd {

  def main(args:Array[String]){
    val lis=List("1","2","3","4","5","6","1","1")
    val list1=List(((3,4), (2,3), (1,2)))
    val conf =new SparkConf().setMaster("local").setAppName("SparkScala")
    val sparkContext=new SparkContext(conf)
    val rdd=sparkContext.parallelize(lis)
    
   /* val input: RDD[(String,Int)]=
      implicit val sortInt=new Ordering[Int]{
      override def compare(a:Strnig,b:String)=a.compare(b)
    }
    input.sortByKey(ascending, numPartitions);*/
    val rdd1=sparkContext.parallelize(list1)
    val pairRDD=rdd.map(x=> (x,1)).reduceByKey((x,y)=>(x+y))
   /* val pairRDD1=rdd1.map(x=> (x,"gopal"))
    val pairRDD2=pairRDD.join(pairRDD1)*/
    
    /*sparkContext.sequenceFile("hdfs://").partitionByKey(new HashPartioner(100)).persist()*/
    pairRDD.lookup("1").foreach(x=>println("######## >>>>>>>>  ::"+x))
    
    val pairs=sparkContext.parallelize(list1)
   val links= sparkContext.objectFile[(String, Seq[String])]("links").partitionBy(new HashPartitioner(100)).persist()
    var ranks=links.mapValues(v=>1.0)
    
  }
  
}