//package mypackage
//import org.apache.spark.sql.SparkSession
////whenever you import you are imporating objects not the actual filename
////file name just placeholder
//object WordCountx {
//
//  val spark = SparkSession.builder
//    .master("local[*]")
//    .appName("Spark Word Count")
//    .getOrCreate()
//
//  val lines = spark.sparkContext.parallelize(
//    Seq("Spark Intellij Idea Scala test one",
//
//      "Spark Intellij Idea Scala test two",
//      "Spark Intellij Idea Scala test three"))
//
//  val counts = lines
//    .flatMap(line => line.split(regex=" "))
//    .map(word => (word, 1))
//    .reduceByKey(_ + _)
//
//  counts.foreach(println)
//}
