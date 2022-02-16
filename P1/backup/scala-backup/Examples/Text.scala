//samuel's and andrew's code

package Examples
import java.awt.event._
import java.awt._
import javax.swing._
import scala.util.matching.Regex
import scala.io.StdIn._


// Java Program to enter name and password
// using JTextField and JPasswordField

object text { // JTextField
  var t: JTextField = null
  // JPasswordField
  var pass: JPasswordField = null
  // JFrame
  var f: JFrame = null
  // JButton
  var b: JButton = null
  // label to display text
  var l: JLabel = null

  // main class
  def main(args: Array[String]): Unit = { // create a new frame to store text field and button
    f = new JFrame("textfield")
    // create a label to display text
    l = new JLabel("nothing entered")
    // create a new button
    b = new JButton("submit")
    // create a object of the text class
    val te = new unorganized.Examples.text
    // addActionListener to button
    // addActionListener to button
    b.addActionListener(te)
    // create a object of JTextField with 16 columns and initial text
    t = new JTextField("enter name", 16)
    // create a object of passwordField with 16 columns
    pass = new JPasswordField(16)
    // create an object of font type
    val fo = new Font("Serif", Font.ITALIC, 20)
    // set the font of the textfield
    t.setFont(fo)
    // create a panel to add buttons and textfield
    val p = new JPanel
    // add buttons and textfield to panel
    p.add(t)
    p.add(pass)
    p.add(b)
    p.add(l)
    // add panel to frame
    f.add(p)
    // set the size of frame
    f.setSize(300, 300)
    f.show()
  }
}

class text() // default constructor
  extends JFrame with ActionListener {
  // if the button is pressed
  override def actionPerformed(e: ActionEvent): Unit = {
    val s = e.getActionCommand
    if (s == "submit") { // set the text of the label to the text of the field
      unorganized.Examples.text.l.setText("name = " + unorganized.Examples.text.t.getText + "\t Password = " + unorganized.Examples.text.pass.getText)
      val getname = unorganized.Examples.text.t.getText
      println(getname)
      val getpass = unorganized.Examples.text.pass.getText
      println(getpass)
      // set the text of field to blank
      unorganized.Examples.text.t.setText("  ")
      // set the text of password field to blank
      unorganized.Examples.text.pass.setText("")

      userPassInputValidation(getname, getpass)
    }


  }

  def userPassInputValidation(username: String, password: String): Unit = {

    val boolUser = username.matches("(?:username)")
    val boolPass = password.matches("(?:password)")

    if (boolUser) {
      println("Username correct")
    }
    if (boolPass) {
      println("Password correct")
    }
    else {
      println("Username or Password incorrect")
    }
  }
}