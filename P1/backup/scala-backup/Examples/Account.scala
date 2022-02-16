package Examples

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readInt

case class Account() {
  // Creating four ListBuffer which stores
  // the initial details of customer
  var name = new ListBuffer[String]()
  name += ( "Ankit", "Rohit", "Rahul" )
  var balance_current = new ListBuffer[Int]()
  balance_current += ( 20000, 30000, 40000 )
  var account_number = new ListBuffer[Int]()
  account_number += ( 1234, 5678, 9101 )
  var phone_number = new ListBuffer[Long]()
  phone_number += ( 9998273493L, 5569392838L, 6651299039L )
  // details() method is used to show
  // the details of all customer
  def details(): Unit ={
    println("Details of customer is\nNames of customer: " + name +
      "\nBalance list" + "is respectively: " + balance_current +
      "\nAccount number is respectively: " + account_number +
      "\nPhone number" + "is respectively: " + phone_number)
  }
  // Used to add money to a particular account
  def credit(): Unit = {
    var credit_amount: Int = 0
    println("Enter the account number you want to credit in: ")

    // readInt is used to take integer
    // value as input from user
    val acc_num1 = readInt()

    // indexOf() method returns the index
    // of particular element
    val index1 = account_number.indexOf(acc_num1)
    println("Enter the amount you want to credit: ")
    credit_amount = readInt()
    balance_current(index1) += credit_amount
    println("Amount added successfully\nNew Balance is: " +
      balance_current(index1))
  }
  // Used to withdraw money from an account
  def debit(): Unit ={
    var debit_amount : Int = 0
    println("Enter the account number " +
      "you want to withdraw from: ")
    val acc_num2 = readInt()
    val index2 = account_number.indexOf(acc_num2)
    println("Enter the amount you want to withdraw: ")

    debit_amount = readInt()
    balance_current(index2) -= debit_amount
    println("Money withdrawn successfully\n" +
      "Remaining balance is: " +
      balance_current(index2))
  }

}
