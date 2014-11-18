package pis.chap6.rational

import org.scalatest._

/**
 * Created by fiona on 14/11/14.
 */
class RationalSpec extends FunSpec with Matchers {

  describe("Creating and instance") {

    it("should require a numerator and a denominator") {
      new Rational(3, 4)
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

  describe("add") {
    it("should add together 1/2 and 1/4 to give 6/8") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 4)
      a add b  should be(new Rational(6, 8))
    }

    it("should add together 1/2 and 1/2 to give 4/4") {
      val a = new Rational(1, 2)
      val b = new Rational(1, 2)
      a add b should be (new Rational(4, 4))
    }
  }

}
