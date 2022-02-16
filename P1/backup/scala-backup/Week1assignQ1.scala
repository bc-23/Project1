import scala.io.StdIn

  object Week1assignQ1 {
    //functions-make each question a function
    def ques1(): Unit = {
      val donutName: String = "Vanilla Donut"
      val quantityPurchased: Int = 10
      val price = 2.5
      val donutJson = {
        s"""
          |{
          |"donut_name":"$donutName",
          |"quantity_purchased":"$quantityPurchased",
          |"price":"$price",
          |}
      """.stripMargin
      }
      println(donutJson)

    }

//    def ques2: Unit = (){
//      var Name= String;
//      var Age= Int;
//    }


      def main(args: Array[String]): Unit = {
        ques1()
      }
    }