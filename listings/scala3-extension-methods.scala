case class Circle(x: Double, y: Double, radius: Double = 1.0)

extension (c: Circle)
  def circumference: Double = c.radius * math.Pi * 2

val circle = Circle(0, 0, 5)
println(circle.circumference) // 31.41592653589793

val circle2 = Circle(0, 0) // radius is 1.0, the default value
println(circle2.circumference) // 6.283185307179586
