package test

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import com.opencsv.CSVReader
import java.io.StringReader

object ReadCSV {
  
  def main(args:Array[String]){
        val conf =new SparkConf().setMaster("local").setAppName("SparkScala")
        val sparkContext=new SparkContext(conf)
        val rdd=sparkContext.textFile("")
       /* val result=rdd.map(line=>
          val reader=new CSVReader(new StringReader(line));
          reader.readNext();
        )*/
  }
}