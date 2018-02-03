package controllers

import json.BookingMessage
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import persists.BookingPersist
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers.{GET, contentAsString, route, status, _}

class BookingControllerSpec
  extends PlaySpec
    with GuiceOneAppPerTest {

  "GET /bookings" should {
    "return all bookings" in {
      val persist = app.injector.instanceOf[BookingPersist]
      val booking = BookingMessage(3,4,"AntMan", Map("company" -> "avenger"))
      persist.insert(booking)

      val result = route(app
        , FakeRequest(GET, "/bookings")
      ).get

      status(result) mustBe OK
      contentAsString(result) must include("AntMan")
    }
  }

  "POST /bookings" should {
    "return created bookins" in {
      val booking = BookingMessage(5,6,"SpiderMan", Map("company" -> "avenger"))

      val result = route(app
        , FakeRequest(POST, "/bookings")
          .withJsonBody(Json.parse(booking.toText))
      ).get

      status(result) mustBe OK
      contentAsString(result) must include("SpiderMan")
    }
  }

}
