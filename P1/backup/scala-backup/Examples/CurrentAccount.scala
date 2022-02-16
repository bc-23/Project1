//package Examples
//
//case class CurrentAccount extends Any {
////  def credit() = ???
//
//  var overdraft_limit: Int = 2000
//
//  // Using method overriding
//  // method used to withdraw money
//  override def debit(): Unit ={
//    println("Enter the account number " +
//      "you want to withdraw from: ")
//
//    val acc_num5 = readInt()
//    val index5 = account_number.indexOf(acc_num5)
//    println("Enter the amount you want to withdraw: ")
//    var debit_amount = readInt()
//
//    if ((balance_current(index5) - debit_amount )< 2000)
//    {
//      println("Overdraft limit exceeded " +
//        "transaction declined")
//    }
//    else
//    {
//      balance_current(index5) -= debit_amount
//      println("Transaction successful\n" + "" +
//        "Remaining balance is: " +
//        balance_current(index5))
//    }
//  }
//}
//
//
