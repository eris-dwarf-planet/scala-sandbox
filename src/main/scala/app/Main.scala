package app

import app.example.Expression
import app.example.HelloWorld
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

  }
}
