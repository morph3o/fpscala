package fpscala.datastructures

/*
* - Declaring the abstract interface List with no methods.
* - Sealed means that the implementation of the trait must be in this file.
* - +A means that the List is polymorphic in the type of elements it contains, or that the type is covariant. Therefore
* it is possible to use the same definition for a list of Int, String, etc.
* */
sealed trait List[+A]

/*
* - This is the first constructor of the List which represents an empty list.
* - Nothing is a subtype of all types
* */
case object Nil extends List[Nothing]
/*
* - This is the other constructor which represents the non empty list. The non-empty list
* consists of a head, which contains the value of a generic type A, and the tail which is connected to the next
* List (it may be empty).
* */
case class Cons[+A](head: A, tail: List[A]) extends List[A]
/*
*  List("a","b") == Const("a", Const("b", Nil))
* */

/*
* This is called the companion object. This is an object with the same name of the class
* where we place convenience functions for creating or working with values of this data type (List)
* */
object List {

  /*
  * x = single element
  * xs = sequence of x. The same for as, bs, ys. It is just a convention
  * */
  def sum(ints: List[Int]): Int = ints match{
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  /*
  * we use '_' to indicate a variable whose value we ignore in the result of the case
  * */
  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  // This value of x = 3
  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // This is the case fulfilled
    case _ => 101
  }

  def tail[A](list: List[A]): List[A] = list match{
    case Nil => sys.error("The list is empty")
    case Cons(_, xs) => xs
  }

  def setHead[A](v: A, list: List[A]): List[A] = list match {
    case Nil => sys.error("The list is empty")
    case Cons(_,t) => Cons(v,t)
  }

  def drop[A](l: List[A], n: Int): List[A] = n match {
    case n if n <= 0 => l
    case _ =>
      if(tail(l) == Nil) Nil
      else drop(tail(l), n-1)
  }

  /*
  * The method was improved by:
  * - Moving the if-else statement to the case level
  * - Instead of calling drop method, we just call dropWhile with the tail of the current list
  * */
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h,t) if f(h) => dropWhile(t, f)
    case _ => l
  }

  def init[A](l: List[A]): List[A] =
    l match {
      case Cons(h,t) if (t != Nil) => Cons(h, init(t))
      case _ => Nil
  }

  def init2[A](l: List[A]): List[A] = {
    import collection.mutable.ListBuffer
    val lAux = new ListBuffer[A]
    def loop(cur: List[A]): List[A] = cur match {
      case Nil => sys.error("init of empty list")
      case Cons(_,Nil) => List(lAux.toList: _*)
      case Cons(h,t) => lAux += h; loop(t)
    }
    loop(l)
  }

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)(_ + _) // foldRight(ns, 0)((x,y) => x + y)

  def product2(ns: List[Double]) =
    foldRight(ns, 1.0)(_ * _) // foldRight(ns, 1.0)((x,y) => x * y)

  def length[A](as: List[A]): Int =
    foldRight(as, 0)((_,length) => length + 1)

  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case Cons(h,t) => foldLeft(t, f(z,h))(f)
    }
  }

  def sum3(ns: List[Int]) =
    foldLeft(ns, 0)(_ + _)

  def product3(ns: List[Double]) =
    foldLeft(ns, 1.0)(_ * _)

  def length2[A](ns: List[A]): Int =
    foldLeft(ns, 0)((length, _) => length + 1)

  def reverse[A](l: List[A]): List[A] = {
    l match {
      case Nil => sys.error("reverse of empty list")
      case Cons(h,t) => {
        import collection.mutable.ListBuffer
        val reverseList = new ListBuffer[A]
        def loop(as: List[A]): List[A] = {
          as match {
            case Nil => List(reverseList.toList: _*)
            case Cons(h,t) => reverseList.prepend(foldLeft(as, h)((x,y) => x)); loop(t)
          }
        }
        loop(l)
      }
    }
  }

}