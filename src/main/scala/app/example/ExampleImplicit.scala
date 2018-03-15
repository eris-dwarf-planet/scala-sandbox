package app.example

class ExampleImplicit {}

class RichString(val src: String) {
  def smile: String = src + ":-)"
}

object ExampleImplicit {
  implicit def enrichString(arg: String): RichString = new RichString(arg)

  def executeSample1() = {
    println("[ExampleImplicit:executeSample1]------------------")
    println("Hi, ".smile)
  }
}

object Taps {

  implicit class Tap[T](self: T) {
    def tap[U](block: T => U): T = {
      block(self) //値は捨てる
      self
    }
  }

  def executeSample1() = {
    println("[Taps:executeSample1]------------------")

    "Hello, World"
      .tap { s: String =>
        println(s)
      }
      .reverse
      .tap { s: String =>
        println(s)
      }

  }
}

object Additives {
  trait Additive[A] {
    def plus(a: A, b: A): A
    def zero: A
  }

  implicit object StringAdditive extends Additive[String] {
    def plus(a: String, b: String): String = a + b
    def zero: String = ""
  }

  implicit object IntAdditive extends Additive[Int] {
    def plus(a: Int, b: Int): Int = a + b
    def zero: Int = 0
  }

  implicit object DoubleAdditive extends Additive[Double] {
    def plus(a: Double, b: Double): Double = a + b
    def zero: Double = 0.0
  }

  case class Point(x: Int, y: Int)

  implicit object PointAdditive extends Additive[Point] {
    def plus(a: Point, b: Point): Point = Point(a.x + b.x, a.y + b.y)
    def zero: Point = Point(0, 0)
  }

  def sum[A](lst: List[A])(implicit m: Additive[A]) =
    lst.foldLeft(m.zero)((x, y) => m.plus(x, y))
}

object ExampleImplicit2 {
  import Additives._
  def executeSample2() = {
    println("[ExampleImplicit:executeSample2]------------------")
    println(sum(List(Point(1, 1), Point(2, 2), Point(3, 3))))
    println(sum(List(Point(1, 2), Point(3, 4), Point(5, 6))))
  }
}

object Nums {
  trait Num[A] {
    def plus(a: A, b: A): A
    def minus(a: A, b: A): A
    def multiply(a: A, b: A): A
    def divide(a: A, b: A): A
    def zero: A
  }
  object Num {
    implicit object IntNum extends Num[Int] {
      def plus(a: Int, b: Int): Int = a + b
      def minus(a: Int, b: Int): Int = a - b
      def multiply(a: Int, b: Int): Int = a * b
      def divide(a: Int, b: Int): Int = a / b
      def zero: Int = 0
    }
    implicit object DoubleNum extends Num[Double] {
      def plus(a: Double, b: Double): Double = a + b
      def minus(a: Double, b: Double): Double = a - b
      def multiply(a: Double, b: Double): Double = a * b
      def divide(a: Double, b: Double): Double = a / b
      def zero: Double = 0.0
    }
  }
}

object FromInts {
  trait FromInt[A] {
    def to(from: Int): A
  }

  object FromInt {
    implicit object FromIntToInt extends FromInt[Int] {
      def to(from: Int): Int = from
    }

    implicit object FromIntToDouble extends FromInt[Double] {
      def to(from: Int): Double = from
    }
  }
}

object ExampleImplicit3 {
  import Nums._
  import FromInts._

  def average[A](lst: List[A])(implicit a: Num[A], b: FromInt[A]): A = {
    val length = lst.length
    a.divide(lst.foldLeft(a.zero)((x, y) => a.plus(x, y)), b.to(length))
  }

  def average2[A: Num: FromInt](lst: List[A]): A = {
    val a = implicitly[Num[A]]
    val b = implicitly[FromInt[A]]
    val length = lst.length
    a.divide(lst.foldLeft(a.zero)((x, y) => a.plus(x, y)), b.to(length))
  }

  def executeSample3() = {
    println("[ExampleImplicit3:executeSample3]------------------")
    println(average(List(1, 3, 5)))
    println(average(List(1.5, 2.5, 3.5)))
  }
}

object Serializers {

  trait Serializer[A] {
    def serialize(obj: A): String
  }

  def string[A: Serializer](obj: A): String = {
    implicitly[Serializer[A]].serialize(obj)
  }

  implicit object IntSerializer extends Serializer[Int] {
    def serialize(obj: Int): String = obj.toString
  }

  implicit object StringSerializer extends Serializer[String] {
    def serialize(obj: String): String = obj
  }

  implicit def ListSerializer[A](
      implicit serializer: Serializer[A]): Serializer[List[A]] =
    new Serializer[List[A]] {
      def serialize(obj: List[A]): String = {
        val serializedList = obj.map { o =>
          serializer.serialize(o)
        }
        serializedList.mkString("[", ",", "]")
      }
    }
}

object ExampleImplicit4 {
  import Serializers._

  class MyKlass(val x: Int)

  implicit object MyKlassSerializer extends Serializer[MyKlass] {
    def serialize(klass: MyKlass): String = s"MyKlass(${klass.x})"
  }

  def executeSample4() = {
    println("[ExampleImplicit4:executeSample4]------------------")

    println("serialize list : " + string(List(1, 2, 3)))
    println("serialize list : " + string(List(List(1), List(2), List(3))))
    println("serialize int : " + string(1))
    println("serialize string : " + string("Foo"))
    println("serialize class : " + string(new MyKlass(1)))
  }

}
