package pis.chap6.rational

import org.scalatest._

/**
 * Created by fiona on 14/11/14.
 */
class RationalSpec extends FunSpec with Matchers {

  describe("Creating and instance") {

    it("should be able to be create an instance given a numerator and a denominator") {
      new Rational(3, 4)
    }

    it("should not allow a numerator to be 0") {
      intercept[IllegalArgumentException] {
        new Rational(3, 0)
      }

    }

    it("should be able to be create an instance given just a numerator") {
      val rational = new Rational(3)
      rational.numerator should be(3)
      rational.denominator should be(1)
    }

    it("should normalise the given numerator and denominator") {
      val rational = new Rational(66, 42)
      rational.numerator should be(11)
      rational.denominator should be(7)
    }

  }

  describe("toString") {
    it("should return <numerator / denominator>") {
      new Rational(3, 4).toString should be("3 / 4")
    }
  }

  describe("equals") {
    it("should return true when the numerators and denominators are equal") {
      new Rational(3, 4) should be(new Rational(3, 4))
    }
  }

  describe("lessThan") {
    it("should return true when a < b") {
      val a = new Rational(1, 2)
      val b = new Rational(3, 4)
      a.lessThan(b) should be(true)
    }

    it("should return false when a > b") {
      val b = new Rational(1, 2)
      val a = new Rational(3, 4)
      a.lessThan(b) should be(false)
    }

    it("should return false when a = b") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 2)
      a.lessThan(b) should be(false)
    }
  }

  describe("+") {
    it("should add together 1/2 and 1/4 to give 3/4") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 4)
      a + b should be(new Rational(3, 4))
    }

    it("should add together 1/2 and 1/2 to give 1/1") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 2)
      a + b should be(new Rational(1, 1))
    }
  }

  describe("*") {
    it("should multiply 2/3 and 1/4 to give 1/6") {
      val a = new Rational(2, 3)
      val b = new Rational(1, 4)
      a * b should be(new Rational(1, 6))
    }
  }

  describe("* and + operator precedence") {

    val x = new Rational(1, 2)
    val y = new Rational(2, 3)

    it("should maintain precedence") {
      x + x * y should be(new Rational(5, 6))
      (x + x) * y should be(new Rational(2, 3))
      x + (x * y) should be(new Rational(5, 6))
    }
  }

}
