package app.example

import scala.util.Try

class ExampleOption {}

object ExampleOption {
  def executeSample1() = {
    println("[ExampleOption:executeSample1]------------------")

    val o1: Option[String] = Option("hoge")
    println("some option : " + o1)
    println("some option#get : " + o1.get)
    println("some option#isEmpty: " + o1.isEmpty)
    println("some option#isDefined: " + o1.isDefined)

    val o2: Option[String] = Option(null)
    println("some option : " + o2)
    println("some option#getOrElse : " + o2.getOrElse(""))
    println("some option#isEmpty: " + o2.isEmpty)
    println("some option#isDefined: " + o2.isDefined)

    val result = o1 match {
      case Some(str) => str
      case None      => "not matched"
    }
    println("option match result:" + result)

    println("option map:" + Some(3).map(_ * 3))
    println("option fold:" + Some(3).fold(throw new RuntimeException)(_ * 3))

    println("------------------")
    val v1: Option[Int] = Some(3)
    val v2: Option[Int] = Some(5)
    println("option map nest:" + v1.map(i1 => v2.map(i2 => i1 * i2)))
    println("option map flatten:" + v1.map(i1 => v2.map(i2 => i1 * i2)).flatten)
    println("option flatmap :" + v1.flatMap(i1 => v2.map(i2 => i1 * i2)))
    println("option for  :" + (for {
      i1 <- v1
      i2 <- v2
    } yield i1 * i2))

    println("------------------")
    val v3: Either[String, Int] = Right(123)
    val v4: Either[String, Int] = Left("abc")
    v3 match {
      case Right(i) => println("either right: " + i.toString)
      case Left(s)  => println("either left: " + s)
    }

    println("------------------")
    val v5 = Try(3)
    val v6 = Try(5)
    val v7 = Try(7)

    val ret2 = for {
      i5 <- v5
      i6 <- v6
      i7 <- v7
    } yield i5 * i6 * i7
    println("try result: " + ret2)

  }

  def executeSample2() = {
    println("[ExampleOption:executeSample2]------------------")
    val v1: Option[Int] = Some(2)
    val v2: Option[Int] = Some(3)
    val v3: Option[Int] = Some(5)
    val v4: Option[Int] = Some(7)
    val v5: Option[Int] = Some(11)

    val result1 = v1.map { i1 =>
      v2.map { i2 =>
        v3.map { i3 =>
          v4.map { i4 =>
            v5.map { i5 =>
              i1 * i2 * i3 * i4 * i5
            }
          }.flatten
        }.flatten
      }.flatten
    }.flatten
    println("result1:" + result1)

    val result2 = v1.flatMap { i1 =>
      v2.flatMap { i2 =>
        v3.flatMap { i3 =>
          v4.flatMap { i4 =>
            v5.map { i5 =>
              i1 * i2 * i3 * i4 * i5
            }
          }
        }
      }
    }
    println("result2:" + result2)
  }

}
