package idealized.scala

/**
  * Created by pdivasto on 17-10-2016.
  */
abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, falsee)
  def || (x: => Boolean): Boolean = ifThenElse(truee, x)
  def unary_! : Boolean = ifThenElse(falsee, truee)

  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)

  def < (x: Boolean) = ifThenElse(falsee, x)
}

object truee extends Boolean {
  override def ifThenElse[T](t: => T, e: => T): T = t
}

object falsee extends Boolean {
  override def ifThenElse[T](t: => T, e: => T): T = e
}