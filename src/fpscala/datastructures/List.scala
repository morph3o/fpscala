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
    case Nil => Cons(v, Nil)
    case Cons(x, _) => Cons(v, list)
  }

}