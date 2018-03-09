package app.example

// ----------------
sealed abstract class DayOfWeek
case object Sunday extends DayOfWeek
case object Monday extends DayOfWeek
case object Tuesday extends DayOfWeek
case object Wednesday extends DayOfWeek
case object Thursday extends DayOfWeek
case object Friday extends DayOfWeek
case object Saturday extends DayOfWeek

// ----------------
sealed abstract class Exp
case class Add(lhs: Exp, rhs: Exp) extends Exp
case class Sub(lhs: Exp, rhs: Exp) extends Exp
case class Mul(lhs: Exp, rhs: Exp) extends Exp
case class Div(lhs: Exp, rhs: Exp) extends Exp
case class Lit(value: Int) extends Exp

// ----------------
sealed abstract class Tree
case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree

object BinaryTree {
  //  sealed abstract class Tree
  //  case class Branch(value: Int, left: Tree, right: Tree) extends Tree
  //  case object Empty extends Tree
  //
  def max(t: Tree): Int = t match {
    case Branch(v, Empty, Empty) =>
      v
    case Branch(v, Empty, r) =>
      val x = max(r)
      if (v > x) v else x
    case Branch(v, l, Empty) =>
      val x = max(l)
      if (v > x) v else x
    case Branch(v, l, r) =>
      val x = max(l)
      val y = max(r)
      if (v > x) {
        if (v > y) v else y
      } else {
        if (x > y) x else y
      }
    case Empty =>
      throw new RuntimeException
  }

  def min(t: Tree): Int = t match {
    case Branch(v, Empty, Empty) =>
      v
    case Branch(v, Empty, r) =>
      val x = min(r)
      if (v < x) v else x
    case Branch(v, l, Empty) =>
      val x = min(l)
      if (v < x) v else x
    case Branch(v, l, r) =>
      val x = min(l)
      val y = min(r)
      if (v < x) {
        if (v < y) v else y
      } else {
        if (x < y) x else y
      }
    case Empty =>
      throw new RuntimeException
  }

  def depth(t: Tree): Int = t match {
    case Empty => 0
    case Branch(_, l, r) =>
      val ldepth = depth(l)
      val rdepth = depth(r)
      (if (ldepth < rdepth) rdepth else ldepth) + 1
  }

  def toList(tree: Tree): List[Int] = tree match {
    case Empty => Nil
    case Branch(v, l, r) => toList(l) ++ List(v) ++ toList(r)
  }

  def sort(t: Tree): Tree = {
    def fromList(list: List[Int]): Tree = {
      def insert(value: Int, t: Tree): Tree = t match {
        case Empty => Branch(value, Empty, Empty)
        case Branch(v, l, r) =>
          if (value <= v) Branch(v, insert(value, l), r)
          else Branch(v, l, insert(value, r))
      }
      list.foldLeft(Empty: Tree) { case (t, v) => insert(v, t) }
    }
    fromList(toList(t))
  }

}

object ExampleCaseClass {
  def executeSample1() = {
    println("[ExampleCaseClass:executeSample1]------------------")

    val x: DayOfWeek = Sunday
    val num = x match {
      case Sunday => 1
      case Monday => 2
      case Tuesday => 3
      case Wednesday => 4
      case Thursday => 5
      case Friday => 6
      case Saturday => 6
    }

    println("case match:" + "x: " + x + " num: " + num)
    println("case nextDayOfWeek:" + nextDayOfWeek(x))

  }

  def executeSample2() = {
    println("[ExampleCaseClass:executeSample2]------------------")

    // 1 + ((2 * 3) / 2)
    val example = Add(Lit(1), Div(Mul(Lit(2), Lit(3)), Lit(2)))
    def eval(exp: Exp): Int = exp match {
      case Add(l, r) => eval(l) + eval(r)
      case Sub(l, r) => eval(l) - eval(r)
      case Mul(l, r) => eval(l) * eval(r)
      case Div(l, r) => eval(l) / eval(r)
      case Lit(v) => v
    }

    println("case eval:" + eval(example))

  }

  def executeSample3() = {
    println("[ExampleCaseClass:executeSample3]------------------")

    val tree: Tree = Branch(1, Branch(2, Empty, Empty), Branch(3, Empty, Empty))
    println("BinaryTree#max:" + BinaryTree.max(tree))
    println("BinaryTree#min:" + BinaryTree.min(tree))
    println("BinaryTree#depth:" + BinaryTree.depth(tree))
    println("BinaryTree#toList:" + BinaryTree.toList(tree))
    println("BinaryTree#sort:" + BinaryTree.sort(tree))

  }

  def executeSample4() = {
    println("[ExampleCaseClass:executeSample4]------------------")

    val list = (1 to 5).toList
    println("list#collect:" + list.collect { case i if i % 2 == 1 => i * 2 })

  }

  private def nextDayOfWeek(d: DayOfWeek): DayOfWeek = {
    d match {
      case Sunday => Monday
      case Monday => Tuesday
      case Tuesday => Wednesday
      case Wednesday => Thursday
      case Thursday => Friday
      case Friday => Saturday
      case Saturday => Sunday
    }
  }

}