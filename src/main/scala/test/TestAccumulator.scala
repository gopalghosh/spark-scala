package test

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object TestAccumulator {
  def main(args:Array[String]){
 /*   val sc = new SparkContext(new SparkConf(true))
val file = sc.textFile("file.txt")
val blankLines = sc.accumulator(0)
// Create an Accumulator[Int] initialized to 0
val callSigns = file.flatMap(line => {
if (line == "") {
blankLines += 1 // Add to the accumulator
}
line.split(" ")
})
callSigns.saveAsTextFile("output.txt")
println("Blank lines: " + blankLines.value)*/
  }
}