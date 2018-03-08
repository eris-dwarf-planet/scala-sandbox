package app.example

class Adder {
  def add1(x: Int)(y: Int): Int = {
    println("add1: x:" + x + " y:" + y)
    x + y
  }
  def add2(x: Int, y: Int): Int = {
    println("add2: x:" + x + " y:" + y)
    x + y
  }
}

object Adder {
  def executeSample(): Unit = {
    val adder = new Adder()

    println("------------------")
    println(adder.add1(1)(2))

    println("------------------")
    val fun1 = adder.add1(2) _
    println(fun1(5))

    println("------------------")
    println(adder.add2(3, 4))

    println("------------------")
    val fun2: Int => Int = adder.add2(2, _)
    println(fun2(5))

  }
}