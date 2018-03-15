package app.example

import java.util.Locale

class Expression {
  def executeSample1(): Unit = {
    println("------------------")
    val age = 17
    val res = {
      if (age < 18) {
        "18歳未満です"
      } else {
        "18歳以上です"
      }
    }

    println(res)

    val hoge1: String = new String("hoge1")
    val hoge2: String = new String("hoge2")
    println("string equals 1: " + (hoge1.equals(hoge2)))
    println("string equals 2: " + (hoge1 == hoge2))

  }

  def executeSample2(): Unit = {
    println("------------------")
    var i = 1
    while (i <= 10) {
      println("i = " + i)
      i = i + 1
    }
  }

  def executeSample3(): Unit = {
    println("------------------")
    val list = List("A", "B", "C", "D", "E")
    for (e <- list) println(e)

    println("------------------")
    val list2 = for (e <- list) yield {
      "Pre" + e
    }
    for (e <- list2) println(e)

    println("------------------")
    for (a <- 1 to 10; b <- 1 to 10; c <- 1 to 10 if a * a == b * b + c * c) {
      println((a, b, c))
    }
  }

  def executeSample4(): Unit = {
    println("------------------")
    val taro = "Taro"
    val res = {
      taro match {
        case "Taro"   => "Male"
        case "Jiro"   => "Male"
        case "Hanako" => "Female"
      }
    }
    println(res)

    println("------------------")
    val list = List(List("A"), List("B", "C", "D", "E"))
    list match {
      case List(a @ List("A"), x) =>
        println(a)
        println(x)
      case _ => println("nothing")
    }

    println("------------------")
    val obj: AnyRef = "String Literal"
    obj match {
      case v: java.lang.Integer =>
        println("Integer!")
      case v: String =>
        println(v.toUpperCase(Locale.ENGLISH))
    }

    println("------------------")
    for (i <- 1 to 10) {
      val s =
        new scala.util.Random(new java.security.SecureRandom()).alphanumeric
          .take(5)
          .toList match {
          case List(a, b, c, d, _) => List(a, b, c, d, a).mkString
        }
      println(s)
    }

  }

}
