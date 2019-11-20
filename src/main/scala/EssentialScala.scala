//package io.underscore.essential.scala

object TREES {

  trait Tree {
    def sum(tree: Tree = this): Int = tree match {
      case Leaf(n) => n
      case Node(left, right) => sum(left) + sum(right)
    }
  }
      case class Leaf(n: Int) extends Tree
      case class Node(left: Tree, right: Tree) extends Tree

      val leaf = Leaf(1)
      val node = Node(leaf, leaf)
      val resNode = node.sum()
      val resLeaf = leaf.sum()
      val resLeafNode = leaf.sum(node)

      def mtest (i: Int): String = i match {
        case 1 | 2 => "yes"
        case 3 => "no"
        case _ => "unknown input"
      }

      lazy val _f  = for {
        xs <- List(1 to 5)
        x <- xs
      } yield println(mtest(x))



      def _map[A,B](xs: List[A], f: A=>B): List[B]= {
        xs match {
          case Nil => Nil
          case y :: ys => f(y) :: _map(ys, f)
        }
      }

      val ls = (1 to 10).toList
      lazy val _m = _map(ls, println)

}

object CATS {

  def run {

    trait lionData {
      def colour: String
      def sound: String
      def maneSize: Int
    }

  val lion_massive = Lion("blue", "roar", 10)
  val lion_tiny = Lion("golden", "roar", 5)

  lion_massive.print
  lion_tiny.print

  }

  trait Feline {
    def colour: String
    def sound: String
    def print: Unit
  }
  case class Cat (colour: String, sound: String) extends Feline {
    def print = println(s"this is a $colour cat, it says $sound")
  }
  case class Lion (colour: String, sound: String, maneSize: Int) extends Feline {
    def print = println(s"this is a $colour lion, it says $sound. behold his ${if (maneSize < 10) "tiny" else "massive"} mane!  ")
  }
}


object TraitsAndOtherAnimals {
  //P94+
  import java.util.Date

  def run {
    def wait = Thread.sleep(1000)
    val tom  = {
      wait
      User(1)
    }
    val bill = {
      wait
      User(2)
    }
    val simpleMonadicPrint: Any => Option[Unit] = s => Some(println(s))
    for {
      a <- tom.age //opt Long
      b <- bill.age //opt Long
      _  <- simpleMonadicPrint((a,b)) //opt any
    } yield ()
  }

  sealed trait Visitor {
    def id: Int
    def createdAt: Date
    def age: Option[Long] = Some(new Date().getTime() - createdAt.getTime())
  }

  final case class User      (id: Int, createdAt: Date = new Date()) extends Visitor
  final case class Anonymous (id: Int, createdAt: Date = new Date()) extends Visitor

}

CATS.run
TraitsAndOtherAnimals.run
