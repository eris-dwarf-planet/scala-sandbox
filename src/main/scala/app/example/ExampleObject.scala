package app.example

class Point(val x: Int, val y: Int) {
  def +(p: Point): Point = {
    println("x:" + x + " y:" + y + " / p.x:" + p.x + " p.y:" + p.y)
    new Point(x + p.x, y + p.y)
  }

  override def toString(): String = {
    println("------------------")
    "(" + x + ", " + y + ")"
  }
}

object Point {
  def executeSample(p1: Point, p2: Point) = {
    println("------------------")
    println(p1 + p2)
  }
}
