package app.example

class User(private val name: String,
           private val age: Int,
           private val weight: Int)

object User {
  def executeSample1(user: User) = {
    println("------------------")
    println(
      "name: " + user.name + " age: " + user.age + " weight: " + user.weight)
  }

  def executeSample2() = {
    println("------------------")
    val user = new User("Taro", 20, 70)
    println(
      "name: " + user.name + " age: " + user.age + " weight: " + user.weight)
  }

}

abstract class PrinterA {
  def executeSample1(): Unit
  def executeSample2(): Unit
}

class PrinterB extends PrinterA {
  def executeSample1(): Unit = {
    println("------------------:B:executeSample1")
  }

  def executeSample2(): Unit = {
    println("------------------:B:executeSample2")
  }

  def print(): Unit = {
    println("B")
  }

}

object PrinterB {
  def executeSample(): Unit = {
    val printer = new PrinterB()
    printer.executeSample1()
    printer.executeSample2()
    printer.print()
  }

}

class PrinterC extends PrinterB {
  override def executeSample1(): Unit = {
    println("------------------:C:executeSample1")
  }

  override def executeSample2(): Unit = {
    println("------------------:C:executeSample2")
  }

  override def print(): Unit = {
    println("C")
  }

}

object PrinterC {
  def executeSample(): Unit = {
    val printer = new PrinterC()
    printer.executeSample1()
    printer.executeSample2()
    printer.print()
  }

}
