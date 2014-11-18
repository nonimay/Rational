package pis.chap6.rational

/**
 * Created by fionamcdonald on 14/11/14.
 */
class Rational(n : Int, d: Int) {

  val numerator: Int = n
  val denominator: Int = d

  override def toString = numerator + " / " + denominator

  override def equals(other: Any) = {
    other match {
      case r: Rational => r.numerator == numerator && r.denominator == denominator
      case _ => false
    }
  }

  def lessThan(other: Rational): Boolean = {
    this.numerator * other.denominator < this.denominator * other.numerator
  }

  def add(other: Rational): Rational = {
    new Rational(this.numerator * other.denominator + this.denominator * other.numerator, this.denominator * other.denominator)
  }
}
