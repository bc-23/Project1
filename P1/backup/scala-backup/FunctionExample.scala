object FunctionExample {
  def main(args: Array[String]): Unit = {

    // three args are passed in:
    // 1) 'f' - a function that takes an Int and returns an Int
    // 2) 'a' - an Int
    // 3) 'b' - an Int
    def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)

    // these three functions use the sum() function
    def sumInts(a: Int, b: Int): Int = sum(id, a, b)

    def sumSquares(a: Int, b: Int): Int = sum(square, a, b)

    def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)

    // three functions that are passed into the sum() function
    def id(x: Int): Int = x

    def square(x: Int): Int = x * x

    def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

    // this simply prints the number 10
    println("sum ints 1 to 4 = " + sumInts(1, 4))
  }
}
