package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object TsetRDD {
  def main(args: Array[String]): Unit ={
    println("starting")
   val conf =new SparkConf().setMaster("local").setAppName("SparkScala")
   val sparkContext=new SparkContext(conf)
   val rdd=sparkContext.textFile("/home/gopal/workspace/input.txt")
   val words=rdd.flatMap(line=>line.split(" "))
   val counts=words.map(word=>(word,1)).reduceByKey{case (x,y)=>x+y}
   counts.saveAsTextFile("/home/gopal/ScalaWork/test12.txt")
   println("---------------------------")
   rddFromCollection(sparkContext);
   println("end")
  }
  
  def rddFromCollection(ctx:SparkContext){
    val ls=List(1,2,3,4,6)
    val rddFromList=ctx.parallelize(ls)
    val result =rddFromList.map(x=>x*x)
    println("value============ >>>>>>>> "+result)
  }
}