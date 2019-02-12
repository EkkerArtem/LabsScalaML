package lecture_3.parts5_7

class Rational(x: Int, y: Int) {
  require(y != 0, "Denominator must be nonzero")
  //assert(y != 0, "Denominator must be nonzero")

  def this(x: Int) = this(x , 1)

  private def gcb(a: Int, b: Int): Int = if (b == 0) a else gcb(b, a % b)

  def numerator: Int = x

  def denominator: Int = y

  def + (that: Rational) =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  override def toString: String ={
    val g = gcb(numerator, denominator)
    numerator/g + "/" + denominator/g
  }

  def unary_- =
    new Rational(
      -numerator,
      denominator
    )

  /*def sub(that:Rational) =
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )*/

  def - (that: Rational): Rational = this + -that

  def < (that: Rational): Boolean =
    numerator * that.denominator < that.numerator * denominator

  def max(that: Rational) = if (this<that) that else this
}
