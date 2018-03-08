package app.example

class HelloWorld {
  def executeSample(args: Array[String]): Unit = {
    println("------------------")
    println("Hello, World! : " + args.mkString)
  }
}

