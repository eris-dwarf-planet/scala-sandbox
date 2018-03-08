package app.example

// ---------
trait TraitA {
}

trait TraitB {
}

class TraitClassA {
}

class TraitClassB extends TraitClassA with TraitA with TraitB {
}

// ---------
trait TraitC {
  val name: String
  def printName(): Unit = println(name)
}

class TraitClassC(val name: String) extends TraitC {
}

object ObjectC {
  val a = new TraitClassC("dwango")
  val a2 = new TraitC { val name = "kadokawa" }
}

// ---------
trait TraitD {
  def greet(): Unit
}

trait TraitE extends TraitD {
  def greet(): Unit = println("Good morning!")
}

trait TraitF extends TraitD {
  def greet(): Unit = println("Good evening!")
}

class TraitClassD extends TraitE with TraitF {
  override def greet(): Unit = println("How are you?")
}

class TraitClassE extends TraitE with TraitF {
  override def greet(): Unit = super[TraitE].greet()
}

class TraitClassF extends TraitE with TraitF {
  override def greet(): Unit = {
    super[TraitE].greet()
    super[TraitF].greet()
  }
}

object TraitClassD {
  def executeSample() = {
    println("[TraitClassD]------------------")
    val obj = new TraitClassD()
    obj.greet()
  }
}

object TraitClassE {
  def executeSample() = {
    println("[TraitClassE]------------------")
    val obj = new TraitClassE()
    obj.greet()
  }
}

object TraitClassF {
  def executeSample() = {
    println("[TraitClassF]------------------")
    val obj = new TraitClassF()
    obj.greet()
  }
}

// ---------
trait TraitG {
  def greet(): Unit = println("TraitG: Hello!")
}

trait TraitH extends TraitG {
  override def greet(): Unit = {
    super.greet()
    println("TraitH: My name is Terebi-chan.")
  }
}

trait TraitI extends TraitG {
  override def greet(): Unit = {
    super.greet()
    println("TraitI: I like niconico.")
  }
}

class TraitClassH extends TraitH with TraitI
class TraitClassI extends TraitI with TraitH

object TraitClassH {
  def executeSample() = {
    println("[TraitClassH]------------------")
    val obj = new TraitClassH()
    obj.greet()
  }
}

object TraitClassI {
  def executeSample() = {
    println("[TraitClassI]------------------")
    val obj = new TraitClassI()
    obj.greet()
  }
}

// ---------
trait Greeter {
  def greet(): Unit
}

trait Robot {
  self: Greeter =>

  def start(): Unit = greet()
  override final def toString = "Robot"
}

trait Robot2 extends Greeter {
  def start(): Unit = greet()
  override final def toString = "Robot2"
}

trait HelloGreeter extends Greeter {
  def greet(): Unit = println("Hello!")
}

object Robot {
  def executeSample() = {
    println("[Robot]------------------")
    val obj = new Robot with HelloGreeter
    obj.start()
    obj.greet()
  }
}

object Robot2 {
  def executeSample() = {
    println("[Robot2]------------------")
    val obj = new Robot2 with HelloGreeter
    obj.start()
    obj.greet()
  }
}

