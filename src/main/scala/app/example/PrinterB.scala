package app.example

class PrinterB extends PrinterA {
  def executeSample1(): Unit = {
    println("------------------:B:executeSample1")
  }

  def executeSample2(): Unit = {
    println("------------------B::executeSample2")
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