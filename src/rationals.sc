object rationals {
  var x = new Rational(4, 0)
  var y = new Rational(2, 3)

  println(x.toString)
}

val x = new Rational(4, 2)
val y = new Rational(2, 3)

println(x.toString)

println("Test!")

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  private def gcd(a: Int, b: Int): Int =
    b match {
      case 0 => a
      case _ => gcd(b, a % b)
    }

  private val g = gcd(x,y)

  var numer = x
  var denom = y

  def this(x: Int) = this(x,1)

  def less(that: Rational) =
    numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom
    )

  def neg: Rational =
    new Rational(-this.numer, this.denom)

  override def toString =
    (numer / g).toString + "/" + (denom / g).toString
}