import scala.io.StdIn.readLine

object Week1assignQ6 {
  def main(args: Array[String]): Unit = {

    val firstName = readLine("Enter your first name:  ")
    val lastName = readLine("Enter your last name:  ")
    val favMovie = readLine("Enter your favorite movie")

    println("First Name:  " + firstName)
    println("Last Name:  " + lastName)
    println("Favorite movie :  " + favMovie)
    print(Console.UNDERLINED)
  }
}
