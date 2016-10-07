object Week2 {
  def sumOld(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, f(a))
  }

  sumOld(x => x)(1, 5)

  def sum(f: Int => Int)(a: Int, b: Int): Int =
    if(a > b) 0 else f(a) + sum(f)(a + 1, b)

  def product(f: Int => Int)(a: Int, b: Int): Int =
    if(a > b) 1 else f(a) * product(f)(a + 1, b)

  product(x => x)(1, 3)

  def fact(n: Int): Int =
    product(x => x)(1, n)

  fact(5)

  def mapReduce(f: Int => Int)(a: Int, b: Int)(z: Int)(op: (Int, Int) => Int): Int =
    if(a > b) z else op(a, mapReduce(f)(a + 1, b)(z)(op))

  def mapReduceCourse(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if(a > b) zero else combine(f(a), mapReduceCourse(f, combine, zero)(a + 1, b))

  mapReduce(x => x)(1, 3)(0)((a,b) => a + b)

  import math.abs
  val tolerance = 0.0001

  def isClosedEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isClosedEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  def averageDamp(f: Double => Double)(x: Double): Double =
    (x + f(x))/2

  def sqrt1(x: Double) = fixedPoint(y => (y + x/y) / 2)(1.0)

  def sqrt(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1.0)

  sqrt(2)


}