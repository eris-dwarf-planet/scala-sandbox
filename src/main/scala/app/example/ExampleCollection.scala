package app.example

import scala.collection.mutable

class ExampleCollection {
  def swapArray[T](arr: Array[T])(i: Int, j: Int): Unit = {
    val x: T = arr(i)
    arr(i) = arr(j)
    arr(j) = x
  }

  def joinByComma(start: Int, end: Int): String = {
    val array = (start to end).toList
    return array.mkString(",")
  }

  def reverse[T](list: List[T]): List[T] = {
    list.foldLeft(Nil: List[T])((a, b) => b :: a)
  }

  def sum(list: List[Int]): Int = {
    list.foldRight(0) { (a, b) => a + b }
  }

  def mul(list: List[Int]): Int = {
    list.foldRight(1)((x, y) => x * y)
  }

  def mkString[T](list: List[T])(sep: String): String = {
    list match {
      case Nil => ""
      case x :: xs => xs.foldLeft(x.toString())((x, y) => x + sep + y)
    }
  }

  def map[T, U](list: List[T])(f: T => U): List[U] = {
    //    list.foldLeft(Nil: List[U]) { (x, y) => x :+ f(y) }
    list.foldLeft(Nil: List[U]) { (x, y) => f(y) :: x }.reverse
  }

  def filter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil: List[T]) { (x, y) =>
      if (f(y)) y :: x else x
    }.reverse
  }

  def count[T](list: List[T])(f: T => Boolean): Int = {
    list.foldLeft(0) { (x, y) =>
      if (f(y)) x + 1 else x
    }
  }

}

object ExampleCollection {
  def executeSample1() = {
    println("[ExampleCollection:executeSample1]------------------")
    val array = Array[Int](1, 2, 3, 4, 5)
    println("array: " + array.mkString(","))

    array(0) = 10
    println("array(0): " + array(0))
    println("array.length: " + array.length)
  }

  def executeSample2() = {
    println("[ExampleCollection:executeSample2]------------------")
    val obj = new ExampleCollection()
    val array = Array[Int](1, 2, 3, 4, 5)
    println("array: " + array.mkString(","))

    obj.swapArray(array)(2, 4)
    println("swap array(2 <-> 4): " + array.mkString(","))
  }

  def executeSample3() = {
    println("[ExampleCollection:executeSample3]------------------")
    val list1 = (1 to 5).toList
    println("list range 1 to 5: ")
    for (x <- list1) println(x)

    val list2 = (1 until 5).toList
    println("list range 1 until 5: ")
    for (x <- list2) println(x)

    println("------------------")
    val a1 = 1 :: Nil
    val a2 = 2 :: a1
    println("list a2: " + a2.mkString(","))

    val a3 = 1 :: 2 :: 3 :: 4 :: Nil
    println("list a3: " + a3.mkString(","))

    val a4 = Nil.::(4).::(3).::(2).::(1)
    println("list a4: " + a4.mkString(","))

    val a5 = List(1, 2) ++ List(3, 4)
    println("list a5: " + a5.mkString(","))

    val a6 = List(1, 2).++(List(3, 4, 5))
    println("list a6: " + a6.mkString(","))

    val obj = new ExampleCollection()
    println(obj.joinByComma(1, 10))
  }

  def executeSample4() = {
    println("[ExampleCollection:executeSample4]------------------")
    val obj = new ExampleCollection()

    val list1 = (1 to 5).toList
    val sumValue = list1.foldLeft(0)((x, y) => x + y)
    println("foldLeft: " + sumValue)

    println("------------------")
    println(obj.reverse(list1))

    println("------------------")
    //    val list2 = List()
    println("sum: " + obj.sum(list1))

    println("------------------")
    println("mul: " + obj.mul(list1))

    println("------------------")
    val list2 = List("aa", "bb", "cc", "dd", "ee")
    println("mkString: " + obj.mkString(list2)(","))
  }

  def executeSample5() = {
    println("[ExampleCollection:executeSample5]------------------")
    val obj = new ExampleCollection()

    val list1 = (1 to 5).toList
    val resList = list1.map(x => x * 2)
    println("map resList: " + resList.mkString(","))

    println("------------------")
    println("map resList: " + obj.map(list1)(x => x * 2))
  }

  def executeSample6() = {
    println("[ExampleCollection:executeSample6]------------------")
    val obj = new ExampleCollection()

    val list1 = (1 to 5).toList
    val resList = list1.filter(x => x % 2 == 1)
    println("filter resList: " + resList.mkString(","))

    println("------------------")
    println("filter resList: " + obj.filter(list1)(x => x % 2 == 1))
  }

  def executeSample7() = {
    println("[ExampleCollection:executeSample7]------------------")
    val obj = new ExampleCollection()

    val list1 = (1 to 5).toList
    println("find: " + list1.find(x => x % 2 == 1))

    println("------------------")
    println("takeWhile: " + list1.takeWhile(x => x != 5))

    println("------------------")
    println("count: " + list1.count(x => x % 2 == 0))

    println("------------------")
    println("count: " + obj.count(list1)(x => x % 2 == 0))

    println("------------------")
    println("flatMap: " + List(1, 2, 3).flatMap { e => List(4, 5).map(g => e * g) })

  }

  def executeSample8() = {
    println("[ExampleCollection:executeSample8]------------------")

    //    val vector1 = Vector(1, 2, 3, 4, 5)
    val vector2 = (1 to 5).toVector
    println("vector: " + vector2)
    val vector3 = 6 +: vector2 :+ 7
    println("vector: " + vector3.updated(1, 100))
  }

  def executeSample9() = {
    println("[ExampleCollection:executeSample9]------------------")

    val hashMap = Map("A" -> 1, "B" -> 2, "C" -> 3)
    println("map: " + hashMap)
    println("map updated: " + hashMap.updated("B", 100))

    val mHashMap = mutable.Map("A" -> 1, "B" -> 2, "C" -> 3)
    mHashMap("B") = 1000
    println("mutable map: " + mHashMap)

    val hashSet = Set(1, 2, 3, 4, 5)
    println("set: " + hashSet)
    println("set: : " + (hashSet - 5))

    val mHashSet = mutable.Set(1, 2, 3, 4, 5)
    mHashSet -= 5
    println("mutable set: : " + mHashSet)
  }

}
