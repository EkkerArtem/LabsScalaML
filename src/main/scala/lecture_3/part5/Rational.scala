package lecture_3.part5

class Rational(x: Int, y: Int) {
  def numerator: Int = x

  def denominator: Int = y

  def add(that: Rational) =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  override def toString: String = numerator + "/" + denominator

  def neg =
    new Rational(
      -numerator,
      denominator
    )

  /*def sub(that:Rational) =
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )*/

  def sub(that: Rational): Rational = add(that.neg)
}
