
import scala.io.StdIn.{readInt, readLine}

object Week1assignQ2 {
  //functions-make each question a function

  def main(args: Array[String]): Unit = {

    val name = readLine("Enter your name:  ")
    println("Enter your age:  ")
    val age = readInt()
    println(Console.BOLD)
    print("Name:  ")
    print(Console.UNDERLINED)
    print(name)
    println(Console.BOLD)
    print(Console.RESET)
    println(Console.BOLD)
    print("Age:  ")
    print(Console.RESET)
    print(age)
  }
}