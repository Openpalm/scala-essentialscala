object Shapes { 
  import scala.math.Pi

  trait Printable { 
    def putln: Option[Unit]
  }

  sealed trait Shape extends Printable {
    def sides: Int
    def perimeter: Double
    def area: Double
    def putln: Option[Unit] = Some(println(s"i have $sides sides, making my perimeter $perimeter, and area $area"))
  }
  sealed trait Rectangular extends Shape {
    def sideA: Double 
    def sideB: Double

    val sides = 4
    val perimeter = 2 * (sideA + sideB)
    val area = sideA * sideB
  }
  final case class Circle(radius: Long) extends Shape {
    val sides = 0
    val area = Pi * Math.pow(radius,2)
    val perimeter = (2*Pi*radius)
  }

  final case class Rectangle(sideA: Double, sideB: Double) extends Rectangular
  final case class Square(side: Double) extends Rectangular {
    val sideA, sideB = side
    override val area = Math.pow(side,2)
    override val perimeter =  4*side
    override def putln: Option[Unit] = {
      print("i am a square and ")
      super.putln
    }
  }

  def run { 
    for { 
     _ <- Square(3).putln
    } yield ()
  }
}

Shapes.run
