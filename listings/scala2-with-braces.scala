if (x < 0) {
  println("negative")
} else if (x == 0) {
  println("zero")
} else {
  println("positive")
}

val y = if (a < b) { a } else { b }


val ints = List(1, 2, 3, 4, 5)
for (i <- ints) println(i)

val doubles = for (i <- ints) yield i * 2


var z = 1
while (z < 3) {
  println(z)
  z += 1
}


val result = i match {
  case 1 => "one"
  case 2 => "two"
  case _ => "other"
}


class Person(var firstName: String, var lastName: String) {
  def printFullName() = {
    println(s"First name: $firstName")
    println(s"Last name: $lastName")
  }
}

val p = new Person("John", "Stephens")
