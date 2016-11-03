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