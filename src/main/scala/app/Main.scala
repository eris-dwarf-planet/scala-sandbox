package app

import app.example.{Cell, ExampleCaseClass, ExampleCollection, ExampleFunction, ExampleFuture, ExampleImplicit, ExampleImplicit2, ExampleImplicit3, ExampleImplicit4, ExampleOption, Expression, HelloWorld, Pair, Person, Point, PrinterB, PrinterC, Robot, Robot2, Taps, TestStack, TraitClassD, TraitClassE, TraitClassF, TraitClassH, TraitClassI, User}

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
    Person.printWeight()

    ExampleFunction.executeSample()

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

    ExampleCaseClass.executeSample1()
    ExampleCaseClass.executeSample2()
    ExampleCaseClass.executeSample3()
    ExampleCaseClass.executeSample4()

    ExampleOption.executeSample1()
    ExampleOption.executeSample2()

    ExampleImplicit.executeSample1()
    Taps.executeSample1()
    ExampleImplicit2.executeSample2()
    ExampleImplicit3.executeSample3()
    ExampleImplicit4.executeSample4()

    ExampleFuture.executeSample1()
  }

}
