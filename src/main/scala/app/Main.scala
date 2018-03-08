package app

import app.example.Adder
import app.example.Expression
import app.example.HelloWorld
import app.example.Point
import app.example.PrinterB
import app.example.PrinterC
import app.example.User

object Main {
  def main(args: Array[String]): Unit = {
    val ex1 = new HelloWorld()
    ex1.executeSample(Array("hello-", "hoge"))

    val ex2 = new User("dwango", 13)
    User.executeSample(ex2)

    val ex3 = new Expression()
    ex3.executeSample1()
    ex3.executeSample2()
    ex3.executeSample3()
    ex3.executeSample4()

    val p1 = new Point(1, 2)
    val p2 = new Point(3, 4)
    Point.executeSample(p1, p2)

    Adder.executeSample()

    PrinterB.executeSample()
    PrinterC.executeSample()
  }
}
