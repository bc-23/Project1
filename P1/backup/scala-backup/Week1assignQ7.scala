object Week1assignQ7 {
  def main(args: Array[String]): Unit = {
    val str = "Vanilla Donut 10 2.25"
    val str2 = str.split(' ')
    println("Donut Name: " + str2(0) + " " + str2(1))
    println("Donut Price : $ " + str2(3).toDouble)
    println("Donut Purchased: " + str2(2).toInt)
  }
}
