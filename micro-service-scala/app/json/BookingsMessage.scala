package json

import utilities.Json

case class BookingsMessage(list: List[BookingMessage])
  extends Json

case class BookingMessage(id: Int
                          , seat: Int
                          , bookerName: String
                          , info: Map[String, String])
  extends Json