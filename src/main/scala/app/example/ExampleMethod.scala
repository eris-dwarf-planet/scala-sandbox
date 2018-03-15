package app.example

class ExampleFunction {
  def add1(x: Int)(y: Int): Int = {
    println("add1: x:" + x + " y:" + y)
    x + y
  }
  def add2(x: Int, y: Int): Int = {
    println("add2: x:" + x + " y:" + y)
    x + y
  }

  def double(n: Int, f: Int => Int): Int = {
    f(f(n))
  }

  def around(init: () => Unit, body: () => Any, fin: () => Unit): Any = {
    init()
    try {
      body()
    } finally {
      fin()
    }
  }
}

object ExampleFunction {
  def executeSample(): Unit = {
    val func = new ExampleFunction()

    println("[func add]------------------")
    println(func.add1(1)(2))

    println("------------------")
    val fun1 = func.add1(2) _
    println(fun1(5))

    println("------------------")
    println(func.add2(3, 4))

    println("------------------")
    val fun2: Int => Int = func.add2(2, _)
    println(fun2(5))

    println("[func double]------------------")
    println(func.double(1, m => m * 2))
    println(func.double(2, m => m * 3))
    println(func.double(3, m => m * 4))

    println("[func around]------------------")
    func.around(() => println("open file"),
                () => println("throw exception"), //throw new Exception("throw exception"),
                () => println("close file"))

  }
}
