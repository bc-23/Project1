object Demo1 {

  object Math {
    def add_(x: Int, y: Int): Int = {
      return x + y
    }
    def square(x: Int) = x*x
  }

  def add(x: Int, y: Int): Int = {
    return x + y
  }
  def subtract(x: Int, y: Int): Int = {
    return x - y
  }
  def multiply(x: Int, y: Int): Int = {
    return x * y
  }
  def divide(x: Int, y: Int): Int = {
    return x / y
  }
  def divide1(x: Int, y: Int): Int =  x / y
  //note you don't even need the return keyword!!!!
  //note you can also forget the curly brackets!!!
  def main(args: Array[String]): Unit = {
    println(add(2,3))
    println(Math.add_(2,3))
    println(Math.square(3))
    println(subtract(12,3))
    println(multiply(12,3))
    println(divide(12,3))
    println(divide1(12,3))
  }
}
