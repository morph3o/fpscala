import scala.collection.mutable

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => xs.takeWhile(y => x == y) :: pack(xs1.dropWhile(y => x == y))
}

var l = List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))

List("a", "a", "a", "b", "c", "c", "a").takeWhile(x => x == "a")

pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs).map(l => (l.head, l.size))

encode(List("a", "a", "a", "b", "c", "c", "a"))

List(("a", 3), ("b", 1), ("c", 2), ("a", 1))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( f(_) :: _ )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( (x, y) => y + 1 )

lengthFun(List("a", "a", "a", "b", "c", "c", "a"))

'1'.toString.toInt
1.toChar


def decrypt(data: String): String = {
  val stringBuilder = new mutable.StringBuilder()
  val chars = data.toCharArray
  var aChar: Char = 'a'
  for (aChar <- chars) {
    if (Character.isDigit(aChar)) {
      println(aChar, Character.isDigit(aChar.toChar), aChar.toString.toInt, (9 - aChar.toString.toInt))
      stringBuilder.+((9 - aChar.toString.toInt).toChar)
    } else {
      stringBuilder.+(aChar)
    }
  }
  println(stringBuilder.toString())
  stringBuilder.reverse.toString()
}

decrypt("ebf2251d2bec-a270-9525-de24-b7f08514")