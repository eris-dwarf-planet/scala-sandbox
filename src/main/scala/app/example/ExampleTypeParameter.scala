package app.example

class Cell[A](var value: A) {
  def put(newValue: A): Unit = {
    value = newValue
  }

  def get(): A = value
}

object Cell {
  def executeSample() = {
    println("[Cell]------------------")
    val cell = new Cell[Int](1)
    cell.put(2)
    println(cell.get())
  }
}

class Pair[A, B](val a: A, val b: B) {
  override def toString(): String = "(" + a + "," + b + ")"
}

object Pair {
  def divide(m: Int, n: Int): Pair[Int, Int] = new Pair[Int, Int](m / n, m % n)

  def executeSample() = {
    println("[Pair]------------------")
    println(divide(7, 3))
  }
}

// ------------------
trait Stack[+A] {
  def push[E >: A](e: E): Stack[E]
  def top: A
  def pop: Stack[A]
  def isEmpty: Boolean
}

class NonEmptyStack[+A](private val first: A, private val rest: Stack[A]) extends Stack[A] {
  def push[E >: A](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def top: A = first
  def pop: Stack[A] = rest
  def isEmpty: Boolean = false
}

case object EmptyStack extends Stack[Nothing] {
  def push[E >: Nothing](e: E): Stack[E] = new NonEmptyStack[E](e, this)
  def top: Nothing = throw new IllegalArgumentException("empty stack")
  def pop: Nothing = throw new IllegalArgumentException("empty stack")
  def isEmpty: Boolean = true
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}

object TestStack {
  def executeSample() = {
    println("[TestStack]------------------")
    val intStack: Stack[Int] = Stack()
    println(intStack)

    val stringStack: Stack[String] = Stack()
    println(stringStack)
  }
}



