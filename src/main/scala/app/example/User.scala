package app.example

class User(val name: String, val age: Int)

object User {
  def executeSample(user: User) = {
    println("------------------")
    println(user.name + " " + user.age)
  }
}

