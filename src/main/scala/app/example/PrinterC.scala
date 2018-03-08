package app.example

class PrinterC extends PrinterB {
  override def executeSample1(): Unit = {
    println("------------------:C:executeSample1")
  }

  override def executeSample2(): Unit = {
    println("------------------C::executeSample2")
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