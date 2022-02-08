name := "RevatureTraining"
//make sure name is correct "revaturetraining"
version := "0.1"

scalaVersion := "2.13.8"
//this is your  version
//core,sql, scala

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.2.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.2.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-hive
libraryDependencies += "org.apache.spark" %% "spark-hive" % "3.2.0"


lazy val root = (project in file("."))
  .settings(
    name := "project1"
  )

//what's your project name

//everytime you do something you need a library
//machine leanrin, data frames, etc
//dpends on whether you know what you want