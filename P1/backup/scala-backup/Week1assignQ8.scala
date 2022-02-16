import scala.collection.immutable.ListMap

object Week1assignQ8 {
  def main(args: Array[String]): Unit = {
  val ages = Map("Bill" -> 9, "Johnny" -> 8, "Tommy" -> 11, "Cindy" -> 13)

    var myList  = ListMap(ages.toSeq.sortWith(_._1>_._1):_*)
 var newstring =myList.mkString(" , ")
    println("Children to ages in reverse order by their names = " + newstring)


  }
}
