object Shapes { 
  import scala.math.Pi

  // spice
  trait Printable { 
    def putln: Option[Unit]
  }
 sealed  trait Color {
    case class Color  (R: Int, G: Int, B: Int, V: Int = 0)
    def color: Color
    def isDark: Boolean = color.V > 50
    def isLight: Boolean = !isDark
  }

  // proginators 
  sealed trait Shape extends Printable with Color {
    val color: Color = Color(255, 255, 255) //white
    def name: String
    def sides: Double 
    def perimeter: Double
    def area: Double
    def putln: Option[Unit] = Some(println(s"i am a $name and i have $sides sides, making my perimeter $perimeter, and area $area"))
  }

  sealed trait Rectangular extends Shape {
    def sideA: Double 
    def sideB: Double
    val name = "Rectangular Shape"
    val sides = 4
    val perimeter = 2 * (sideA + sideB)
    val area = sideA * sideB
  }

  // offspring
  final case class Circle(radius: Double) extends Shape {
    val name = "Circle"
    val sides = Double.PositiveInfinity
    val area = Pi * Math.pow(radius,2)
    val perimeter = (2*Pi*radius)
  }
  final case class Rectangle(sideA: Double, sideB: Double) extends Rectangular { 
    override val name = "Rectangle"
  }
  final case class Square(side: Double) extends Rectangular {
    val sideA, sideB = side
    override val name = "Square"
    override val area = Math.pow(side,2)
    override val perimeter =  4*side
  }

  def run { 
    for { 
      _ <- Square(3).putln
      _ <- Rectangle(3,5).putln
      _ <- Circle(6.371).putln //earth.
      _ <- Circle(695.510).putln //sun.
    } yield ()
  }

}

Shapes.run
