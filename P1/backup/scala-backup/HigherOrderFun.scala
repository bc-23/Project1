object HigherOrderFun {
def funcExample (a: Int, f: Int => AnyVal) = {
  println(f(a))
}
  def multipyBy2 (a:Int): Unit = {
    a*2
  }
  def main(args: Array[String]): Unit = {
     println( funcExample(25, multipyBy2))
  }

}
