package controllers

class Example {

  def fizzBuzz(input: Int) = input match {
    case 3 => "Fizz"
    case 5 => "Buzz"
    case _ => input
  }

}
