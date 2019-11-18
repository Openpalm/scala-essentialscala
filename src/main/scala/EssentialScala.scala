//package io.underscore.essential.scala

object PRACTICE {

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
    val lion_massive = Lion("blue", "roar", 10)
    lion_massive.print
    val lion_tiny = Lion("golden", "roar", 5) 
    lion_tiny.print
  }

  sealed trait Feline {
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

CATS.run

