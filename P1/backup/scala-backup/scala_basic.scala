object scala_basic {
  object scala_basic {
    def test(str: String, n: Int): String =
    {
      str.take(n)
    }
    def main(args: Array[String]): Unit = {
      println("Result: " + test("Scala", 1));
      println("Result: " + test("Scala", 0));
      println("Result: " + test("Scala", 4));
    }
  }

}
