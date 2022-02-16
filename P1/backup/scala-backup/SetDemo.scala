object SetDemo {
val mySet: Set[Int] = Set(1,2,2,3,5,7,7,8,9)
  //this is mutable
  var mySet2 = scala.collection.mutable.Set(2,4,5,13,23,33,43,33,5)
  val names: List[String] = List("asdfasd", ";lkj;lkj;", "lj;lkj;lkj")
  def main(args: Array[String]): Unit = {
  println(mySet)
    println(mySet2)
    println(mySet2.head)
    println(mySet2.tail)
    println(mySet2.isEmpty)
    println(mySet2(8))
    println(names)
    println(mySet ++mySet2)
    println(mySet.++(mySet2))
    //notice these two above are the same!!!
    println(mySet.&(mySet2))
  }
}
//MOST IMPORTANT : SET TAKE OUT ALL DUPLICATES !!!
//Point 1: set must be unique value
//Point 2: unordered a& random
//. In Scala sets are the un-ordered collections of unique elements of same data types.
// Scala Sets can be mutable or immutable.
//set are not ordered!
//by itself it's immutable
//to make it mutable you just add scala.collection.mutable.Set(______)