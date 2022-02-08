import org.apache.spark.sql.SparkSession
// TABLES to keep track ofshow
//Branch1Constotcount table has drink , totalcount
//Branch1Branch table has: drink, branch
//Branch1branchcount:  drink, count
//Branch10branch8branch1drink:  drink, branch

//countDrink is count of drinks count is count of consumers
object Main extends App {

 //def main(args: Array[String]): Unit = {
 // create a spark session
 // for Windows
 System.setProperty("hadoop.home.dir", "C:\\winutils")

 //dynamic linking of libraries
 val spark = SparkSession.builder()
   .appName("HiveTest5")
   .config("spark.master", "local")
   .enableHiveSupport()
   .getOrCreate()
 spark.sparkContext.setLogLevel("ERROR")
  println("created spark session")
 //spark.sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING) USING hive")
 //spark.sql("CREATE TABLE IF NOT EXISTS src(key INT, value STRING) ROW FORMAT DELIMITED FIELDS TERMINATED BY ‘,’ STORED AS TEXTFILE")
 //spark.sql("LOAD DATA LOCAL INPATH 'input/kv1.txt' INTO TABLE src")
//LIne 23 - Line 41 all worked
//  spark.sql("create table if not exists Bev_BranchA(drink String, branch String) row format delimited fields terminated by ','");
//  spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchA.txt' OVERWRITE INTO TABLE Bev_BranchA")
//  spark.sql("create table if not exists Bev_BranchB(drink String, branch String) row format delimited fields terminated by ','");
//  spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchB.txt' OVERWRITE INTO TABLE Bev_BranchB")
//  spark.sql("create table if not exists Bev_BranchC(drink String, branch String) row format delimited fields terminated by ','");
//  spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchC.txt' OVERWRITE INTO TABLE Bev_BranchC")
 //SATURDAY new table names BevcountA, BevcountB, BevcountC
//  spark.sql("create table if not exists BevcountA(drink String, count Int) row format delimited fields terminated by ','");
//  spark.sql("LOAD DATA LOCAL INPATH 'input/BevcountA.txt' OVERWRITE INTO TABLE BevcountA")
//  spark.sql("create table if not exists BevcountB(drink String, count Int) row format delimited fields terminated by ','");
//  spark.sql("LOAD DATA LOCAL INPATH 'input/BevcountB.txt' OVERWRITE INTO TABLE BevcountB")
//  spark.sql("create table if not exists BevcountC(drink String, count Int) row format delimited fields terminated by ','");
//  spark.sql("LOAD DATA LOCAL INPATH 'input/BevcountC.txt' OVERWRITE INTO TABLE BevcountC")
// spark.sql("SELECT * FROM Bev_BranchA").show(5)
// spark.sql("SELECT * FROM Bev_BranchB").show(5)
// spark.sql("SELECT * FROM Bev_BranchC").show(5)
// spark.sql("SELECT * FROM BevcountA").show(5)
// spark.sql("SELECT * FROM BevcountB").show(5)
// spark.sql("SELECT * FROM BevcountC").show(5)
//MONDAY PROJECT -
 //val df1 = spark.read.option("multiline", "true").json("input/bank_edited.json")
 //df1.write.saveAsTable("hive_test2")
// spark.sql("SELECT * FROM hive_test2").show
// spark.sql("SELECT * FROM hive_test2 ORDER by age").show(50)
// spark.sql("SELECT MAX(age), MIN(age), ROUND(AVG(age),2) FROM hive_test2").show(10)
 //END OF MONDAY PROJECT CODE FROM JUSTIS
 //Alternative codes to create merged constCount A B C views
 //val branchABC = spark.sql("SELECT * FROM Bev_BranchA UNION SELECT * FROM Bev_BranchB UNION SELECT * FROM Bev_BranchC").show(5)
 //this worked: columns are drink branch
 //
 //branchABC.show()

 //Alternative codes to create merged constCount A B C views
 //val consCountAll = spark.sql("SELECT * FROM BevcountA UNION ALL SELECT * FROM BevcountB UNION ALL SELECT * FROM BevcountC")
 //consCountAll.show()

 //spark.sql("CREATE TABLE if not exists new_tbl AS (SELECT * FROM BevcountA UNION ALL SELECT * FROM BevcountB UNION ALL SELECT * FROM BevcountC)").show()

 //Codes to create merged consCount A, B, and C table - Friday
 // spark.sql("DROP TABLE BevcountABC")
 //spark.sql("CREATE TABLE if not  exists BevcountABC(drink String, countDrink String) row format delimited fields terminated by ','");
 //spark.sql("LOAD DATA LOCAL INPATH 'input/BevcountA.txt' OVERWRITE INTO TABLE BevcountABC")
 //spark.sql("LOAD DATA LOCAL INPATH 'input/BevcountB.txt' INTO TABLE BevcountABC")
 //spark.sql("LOAD DATA LOCAL INPATH 'input/BevcountC.txt' INTO TABLE BevcountABC")
 //Question 1: what is the number of consumer for Branch1?
 //lines 61 to 74 worked
 //Github: create a table called Branch1Branch from previous tables where branch name is equal to Branch 1
// spark.sql("CREATE TABLE if not  exists Branch1Branch AS SELECT * FROM Bev_BranchA where branch = 'Branch1'");
// spark.sql("INSERT INTO TABLE Branch1Branch SELECT * FROM Bev_BranchB where branch = 'Branch1'");
// spark.sql("INSERT INTO TABLE Branch1Branch SELECT * FROM Bev_BranchC where branch = 'Branch1'");

 //**Github tricky part: CREATE a 2nd table Branch1Branchcount which merges tables which has no of consumer with drinks
// spark.sql("CREATE TABLE if not exists Branch1Branchcount(drink String, count Int)")
// spark.sql("INSERT INTO table Branch1Branchcount SELECT BevcountA.drink, sum(BevcountA.count) from Branch1Branch JOIN BevcountA ON (Branch1Branch.drink = BevcountA.drink) GROUP by BevcountA.drink")
// spark.sql("INSERT INTO table Branch1Branchcount SELECT BevcountB.drink, sum(BevcountB.count) from Branch1Branch JOIN BevcountB ON (Branch1Branch.drink = BevcountB.drink) GROUP by BevcountB.drink")
// spark.sql("INSERT INTO table Branch1Branchcount SELECT BevcountC.drink, sum(BevcountC.count) from Branch1Branch JOIN BevcountC ON (Branch1Branch.drink = BevcountC.drink) GROUP by BevcountC.drink")
//spark.sql("SELECT SUM(count) from Branch1Branchcount").show()
 //sume of count = 6695844
 //count=6695844
 //spark.sql("SELECT * from Branch1Branchcount").show(75)

// Question 1: Github way of doing it-1 table Saturday
//spark.sql("CREATE TABLE if not exists Branch1Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch1' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch1' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch1') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch1' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch1' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch1') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch1' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch1' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch1') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
//spark.sql("SELECT SUM(count) FROM Branch1Constotcount").show(75)
//spark.sql("SELECT * FROM Branch1Constotcount").show(80)
 //totalcount = 1115974
 //preparing for Questions 5. Branch 8 part
 //spark.sql("CREATE TABLE if not exists Branch8Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch8' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch8' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch8' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
 //spark.sql("SELECT SUM(totalcount) FROM Branch8Constotcount ORDER BY drink").show(50)
 //spark.sql("SELECT * FROM Branch8Constotcount").show(80)

 //preparing for Questions 5. Branch 4 part
 //spark.sql("CREATE TABLE if not exists Branch4Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch4' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch4' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch4') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch4' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch4' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch4' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch4' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch4') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
 //spark.sql("SELECT SUM(totalcount) FROM Branch4Constotcount ORDER BY drink").show(50)
 //spark.sql("SELECT * FROM Branch4Constotcount").show(80)

 //preparing for Questions 5. Branch 7 part
 //spark.sql("CREATE TABLE if not exists Branch7Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch7' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch7') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch7' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch7' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch7') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch7' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch7' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch7') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
 //spark.sql("SELECT SUM(totalcount) FROM Branch7Constotcount ORDER BY drink").show(50)
 //spark.sql("SELECT * FROM Branch7Constotcount").show(80)
 //Question 2 : what is the number of consumer for Branch2?
 //spark.sql("CREATE TABLE if not  exists Branch2Branch AS SELECT * FROM Bev_BranchA where branch = 'Branch2'");
 //spark.sql("INSERT INTO TABLE Branch2Branch SELECT * FROM Bev_BranchB where branch = 'Branch2'");
 //spark.sql("INSERT INTO TABLE Branch2Branch SELECT * FROM Bev_BranchC where branch = 'Branch2'");
 //spark.sql("CREATE TABLE if not exists Branch2Branchcount(drink String, count Int)")
 //spark.sql("INSERT INTO table Branch2Branchcount SELECT BevcountA.drink, sum(BevcountA.count) from Branch2Branch JOIN BevcountA ON (Branch2Branch.drink = BevcountA.drink) GROUP by BevcountA.drink")
 //spark.sql("INSERT INTO table Branch2Branchcount SELECT BevcountB.drink, sum(BevcountB.count) from Branch2Branch JOIN BevcountB ON (Branch2Branch.drink = BevcountB.drink) GROUP by BevcountB.drink")
 //spark.sql("INSERT INTO table Branch2Branchcount SELECT BevcountC.drink, sum(BevcountC.count) from Branch2Branch JOIN BevcountC ON (Branch2Branch.drink = BevcountC.drink) GROUP by BevcountC.drink")
 //lines 104 and 105 worked
 //spark.sql("SELECT * from Branch2Branchcount").show(80)
 //spark.sql("SELECT SUM(count) from Branch2Branchcount").show()
 //sum of count for Branch2branch2count = 5099141
   //output =  5099151
  //Question 3: What is the most consumed beverage on Branch1?
 //line 111 worked
 //spark.sql("SELECT drink, sum(totalcount) totcount FROM Branch1Constotcount GROUP by drink ORDER by totcount DESC").show(75)
 //result:  Special_cappuccino=  108163
//does line 114 work? where i paused on monday
spark.sql("SELECT drink, sum(totalcount) totcount FROM Branch8Constotcount GROUP by drink ORDER by totcount DESC").show(75)


 //Question 3: What is the least consumed beverage on Branch2?
 //spark.sql("CREATE TABLE if not exists Branch2Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch2' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch2' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch2') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch2' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch2' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch2') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch2' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch2' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch2') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
 //spark.sql("SELECT SUM(totalcount) FROM Branch2Constotcount").show()
 //spark.sql("SELECT drink, sum(totalcount) totcount FROM Branch2Constotcount  ORDER by totcount ASC").show(75)
//cold mocha 47524
 //Question 5: Average of beverage count in Branch 2
 //spark.sql("SELECT * FROM Branch2Constotcount").show(75)
 //spark.sql("SELECT ROUND(avg(totalcount)) FROM Branch2Constotcount").show()
//Question 6: Beverage on branch 10, 8 and 1
//Branch10: this DOES NOT EXIST
 //spark.sql("CREATE TABLE if not exists Branch10Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch10' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch10' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch10') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch10' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch10' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch10') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch10' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch10' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch10') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
//spark.sql("SELECT SUM(totalcount) FROM Branch10Constotcount").show()
 //spark.sql("SELECT * FROM Branch10Constotcount").show(75)
 //spark.sql("CREATE TABLE if not exists Branch10Constotcount AS SELECT drink,totalcount FROM (SELECT BevcountA.drink,sum(BevcountA.count) totalcount from (SELECT drink,branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch8' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) a JOIN BevcountA on (a.drink=BevcountA.drink) GROUP BY BevcountA.drink union all SELECT BevcountB.drink,sum(BevcountB.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch8' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) b JOIN BevcountB on (b.drink=BevcountB.drink) GROUP BY BevcountB.drink UNION ALL SELECT BevcountC.drink,sum(BevcountC.count) totalcount from (SELECT drink, branch FROM (SELECT * FROM Bev_BranchA where branch = 'Branch8' UNION ALL SELECT * from Bev_BranchB where branch = 'Branch10' UNION ALL SELECT * FROM Bev_BranchC where branch ='Branch8') UNIONRESULT) c JOIN BevcountC on (c.drink=BevcountC.drink) GROUP BY BevcountC.drink) UNIONRESULT")
 //spark.sql("SELECT SUM(totalcount) FROM Branch10Constotcount").show()
 //spark.sql("SELECT * FROM Branch10Constotcount").show(75)
//Branch10, Branch 8 and Branch 1 lines 139 and 130 worked - from Github
 //spark.sql("CREATE TABLE IF NOT EXISTS Branch10Branch8Branch1drink AS SELECT drink, branch from (SELECT * from Bev_BranchA where branch ='Branch10' or branch ='Branch8' or branch ='Branch1' UNION ALL SELECT * FROM Bev_BranchB where branch = 'Branch10' or branch ='Branch8' or branch = 'Branch1' UNION ALL SELECT * FROM Bev_BranchC where branch = 'Branch10' or branch = 'Branch8' or branch ='Branch1')UnionResult") //spark.sql("SELECT * FROM Branch10Branch8Branch1drink order by drink").show(75)
 spark.sql("SELECT * FROM Branch10Branch8Branch1drink").show(50)
 println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
 //spark.sql("DROP VIEW myview1")
 //spark.sql("CREATE VIEW myview2 AS SELECT * FROM Branch10Branch8Branch1drink")
 //spark.sql("SELECT * FROM myview2").show(50)
//create partition : create partition table, insert your table into the new partition table
 spark.sql("CREATE TABLE IF NOT EXISTS PartitionT(drink STRING) PARTITIONED BY (branch STRING)")
spark.sql("set hive.exec.dynamic.partition.mode=nonstrict")
spark.sql("INSERT OVERWRITE TABLE PartitionT PARTITION(branch) SELECT drink,branch from Branch10Branch8Branch1drink")
//2 ways of doing it
 //spark.sql("ALTER TABLE Branch10Branch8Branch1drink SET TBLPROPERTIES ('comment' = 'MONDAY NOTES FROM TEST!!!!!!!!!!!1')").show()
 spark.sql("ALTER TABLE PartitionT SET TBLPROPERTIES ('comment' = 'MONDAY NOTES FROM TEST!!!!!!!!!!!1')").show()
 spark.sql("SELECT * FROM PartitionT").show()

//REMOVE A ROW from any scenario - per Bryan

// spark.sql("create table if not exists Bev_BranchA_DeleteTest(drink String, branch String) row format delimited fields terminated by ','");
// spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchA.txt' OVERWRITE INTO TABLE Bev_BranchA_DeleteTest")
//RESULT OF FIRST 3 ROWS OF TABLE
 spark.sql("SELECT * FROM Bev_BranchA_DeleteTest").show(3)
 //1. create copy table
 //spark.sql("CREATE TABLE if not exists Bev_BranchA_DeleteTest_temp LIKE Bev_BranchA_DeleteTest")
 //2. load data into copy table except deleted item
 //spark.sql("INSERT INTO Bev_BranchA_DeleteTest_temp SELECT * FROM Bev_BranchA_DeleteTest WHERE drink NOT IN (SELECT drink FROM Bev_BranchA_DeleteTest WHERE drink='MED_LATTE')")
 //overwrite copy table to original table
 //spark.sql("INSERT OVERWRITE TABLE Bev_BranchA_DeleteTest SELECT * FROM Bev_BranchA_DeleteTest_temp")
 //drop copy table
 //spark.sql("DROP TABLE Bev_BranchA_DeleteTest_temp")
 //show new table with deleted row
 spark.sql("SELECT * FROM Bev_BranchA_DeleteTest").show(3)

}

  //Codes to create merged Branch A, B, and C table
  // spark.sql("CREATE TABLE if not  exists Bev_BranchABC(drink String, branch String) row format delimited fields terminated by ','");
  // spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchA.txt' OVERWRITE INTO TABLE Bev_BranchABC")
  // spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchB.txt' INTO TABLE Bev_BranchABC")
  // spark.sql("LOAD DATA LOCAL INPATH 'input/Bev_BranchC.txt' INTO TABLE Bev_BranchABC")
  //codes below work!!!
  // spark.sql("SELECT * from Bev_BranchABC").show()
  // spark.sql("SELECT * from BevcountABC").show()

  //spark.sql("SELECT * from Bev_BranchABC").show()
  // spark.sql("SELECT * FROM BevcountABC JOIN Bev_BranchABC ON   ")

  // spark.sql("SELECT drink From Bev_BranchABC WHERE branch = 'Branch1'")


  //result = 73634
  //make a table with new column
  // spark.sql("select sum(countDrink) from (SELECT drink From Bev_BranchABC WHERE branch = 'Branch1') where drink='SMALL_Espresso' GROUP BY drink")
  // spark.sql("SELECT count(*) FROM Bev_BranchABC LEFT JOIN BevcountABC ON Bev_BranchABC.drink = BevcountABC.drink").show()
  //result = 73634
  //spark.sql("SELECT count(*) from Bev_BranchABC WHERE branch='Branch1'").show()
  //spark.sql("SELECT count(*) from BevcountABC").show()
  //  val spark = SparkSession.builder
  //    .master("local[*]")
  //    .appName("Spark Word Count")
  //    .getOrCreate()                //CHECK DO NOT SUM EVERYTHING
  //
  //  val lines = spark.sparkContext.parallelize(
  //    Seq("Spark Intellij Idea Scala test one",
  //      "Spark Intellij Idea Scala test two",
  //      "Spark Intellij Idea Scala test three"))
  //
  //  val counts = lines
  //    .flatMap(line => line.split(" "))
  //    .map(word => (word, 1))
  //    .reduceByKey(_ + _)
  //
  //  counts.foreach(println)

