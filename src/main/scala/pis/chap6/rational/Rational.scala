package pis.chap6.rational

/**
 * Created by fionamcdonald on 14/11/14.
 */
class Rational(n : Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  def this(n: Int) = this(n, 1)

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

  def + (other: Rational): Rational = {
    new Rational(this.numerator * other.denominator + this.denominator * other.numerator, this.denominator * other.denominator)
  }

  def * (other: Rational): Rational = {
    new Rational(this.numerator * other.numerator, this.denominator * other.denominator)
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}
