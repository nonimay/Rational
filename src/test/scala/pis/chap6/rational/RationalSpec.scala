package pis.chap6.rational

import org.scalatest._

/**
 * Created by fionamcdonald on 14/11/14.
 */
class RationalSpec extends FunSpec with Matchers {

  describe("Creating and instance") {

    it("should require a numerator and a denominator") {
      new Rational(3, 4)
    }
  }

  describe("toString") {
    it("should override correctly") {
      new Rational(3, 4).toString should be("3 / 4")

    }
  }

}
