package Examples

object MkString {
  // Scala program of mkString()
  // method

  // Creating object

    // Main method
    def main(args:Array[String])
    {

      // Creating map
      val m1 = Map("geeks" -> 5, "for" -> 3, "cs" -> 6)

      // Applying mkString method
      val result = m1.mkString

      // Displays output
      println(result)
    }
 }
