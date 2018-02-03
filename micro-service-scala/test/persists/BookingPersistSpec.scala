package persists

import json.BookingMessage
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest

class BookingPersistSpec
  extends PlaySpec
    with GuiceOneAppPerTest {

  "insert" should {
    "return inserted message if success" in {
      val persist = app.injector.instanceOf[BookingPersist]
      val booking = BookingMessage(1,2,"Captain America", Map(("company" -> "avenger")))

      persist.insert(booking).id mustBe 1
    }
  }

}
