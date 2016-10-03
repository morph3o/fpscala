object CourseraWeek1 {
  def abs(x:Double) = if (x < 0) -x else x

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < improve(guess, x)

  def improve(guess: Double, x: Double) = (guess + x / guess) / 2

  def sqrt(x: Double) = sqrtIter(1.0, x)

  sqrt(0.000001)

  sqrt(1.0e20)

  def factorial(n: Int): Int = {
    def loop(x: Int, y: Int): Int =
      y match {
        case 1 => x
        case _ => loop(x * y, y - 1)
      }
    loop(n, n - 1)
  }

  factorial(4)

}