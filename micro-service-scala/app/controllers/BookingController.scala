package controllers

import javax.inject.Inject

import json.{BookingMessage, BookingsMessage}
import persists.BookingPersist
import play.api.mvc.ControllerComponents

class BookingController @Inject()(cc: ControllerComponents
                                  , persist: BookingPersist)
  extends BaseController(cc) {

  def create = validate[BookingMessage] { implicit form =>
    persist.insert(form)
  }

  def list = handling {
    BookingsMessage(persist.list)
  }

}
