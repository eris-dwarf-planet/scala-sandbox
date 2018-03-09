package app

import app.example.Adder
import app.example.Cell
import app.example.Expression
import app.example.HelloWorld
import app.example.Point
import app.example.PrinterB
import app.example.PrinterC
import app.example.Robot
import app.example.Robot2
import app.example.TraitClassD
import app.example.TraitClassE
import app.example.TraitClassF
import app.example.TraitClassH
import app.example.TraitClassI
import app.example.User
import app.example.Pair
import app.example.TestStack
import app.example.ExampleCollection

object Main {
  def main(args: Array[String]): Unit = {
    val ex1 = new HelloWorld()
    ex1.executeSample(Array("hello-", "hoge"))

    val ex2 = new User("dwango", 13, 50)
    User.executeSample1(ex2)
    User.executeSample2()

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

    TraitClassD.executeSample()
    TraitClassE.executeSample()
    TraitClassF.executeSample()

    TraitClassH.executeSample()
    TraitClassI.executeSample()

    Robot.executeSample()
    Robot2.executeSample()

    Cell.executeSample()
    Pair.executeSample()
    TestStack.executeSample()

    ExampleCollection.executeSample1()
    ExampleCollection.executeSample2()
    ExampleCollection.executeSample3()
    ExampleCollection.executeSample4()
    ExampleCollection.executeSample5()
    ExampleCollection.executeSample6()
    ExampleCollection.executeSample7()
    ExampleCollection.executeSample8()
    ExampleCollection.executeSample9()

  }
}
