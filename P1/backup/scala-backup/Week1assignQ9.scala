import scala.collection.mutable.ArrayBuffer

object Week1assignQ9 {
  def main(args: Array[String]): Unit = {
    var array1 = Array("cake", "milk", "cheese", "toilet paper")
    var array2 = Array("water", "milk","juice","cheese","bread")
    println("Shopping Basket One =")
    for (c <- array1) {
      print(s"${c}, ")
    }
println( "  ")
    println("Shopping Basket Two =")
    for (d <- array2) {
      print(s"${d}, ")
    }
    val temp: ArrayBuffer[String] = ArrayBuffer.empty[String]
    for ( i <- 0 to array1.length - 1) {
      for (j <- 0 to array2.length - 1) {
        if(array1(i).equals(array2(j))) {
          temp.append(array1(i));
        }
      }
    }
    println("\nCommon items are :")
    for (c <- temp) {
      print(s"${c}, ")
    }
  }
}
