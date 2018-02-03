package controllers

import org.scalatestplus.play.PlaySpec

class ExampleSpec
  extends PlaySpec {

  "fizzBuzz" should {
    "input 1 return 1" in {
      val example = new Example

      example.fizzBuzz(1) mustBe 1
    }
    "input 2 return 2" in {
      val example = new Example

      example.fizzBuzz(2) mustBe 2
    }
    "input 3 return Fizz" in {
      val example = new Example

      example.fizzBuzz(3) mustBe "Fizz"
    }
    "input 4 return 4" in {
      val example = new Example

      example.fizzBuzz(4) mustBe 4
    }
    "input 5 return Buzz" in {
      val example = new Example

      example.fizzBuzz(5) mustBe "Buzz"
    }
  }

}
