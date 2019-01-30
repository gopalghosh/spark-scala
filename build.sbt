name := "SparkScala"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.2"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.3.2"
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.5.2"
libraryDependencies += "com.opencsv" % "opencsv" % "4.4"
libraryDependencies += "com.datastax.spark" %% "spark-cassandra-connector" % "2.3.2"