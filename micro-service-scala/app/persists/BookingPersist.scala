package persists

import java.sql.ResultSet
import javax.inject.Inject

import in.norbor.yoda.orm.PStatement
import json.BookingMessage
import play.api.db.Database
import utilities.Json

class BookingPersist @Inject()(db: Database) {

  def insert(booking: BookingMessage) = db.withConnection { implicit conn =>
    PStatement(INSERT)
      .setInt(booking.id)
      .setInt(booking.seat)
      .setString(booking.bookerName)
      .setString(Json.toJson(booking.info))
      .update match {
      case 1 => booking
      case _ => throw new Exception("Cannot Insert")
    }
  }

  def find(id: Int): Option[BookingMessage] = db.withConnection { implicit conn =>
    PStatement(SELECT)
      .setInt(id)
      .queryOne(parse)
  }

  def list: List[BookingMessage] = db.withConnection { implicit conn =>
    PStatement(SELECT_ALL)
      .queryList(parse)
  }

  private def parse(rs: ResultSet): BookingMessage = BookingMessage(
    id = rs.getInt("id")
    , seat = rs.getInt("seat")
    , bookerName = rs.getString("booker_name")
    , info = Json.toObject[Map[String, String]](rs.getString("info")).get
  )

  private lazy val SELECT_ALL =
    """
      | SELECT *
      | FROM bookings
    """.stripMargin

  private lazy val SELECT =
    """
      | SELECT *
      | FROM bookings
      | WHERE id = ?
    """.stripMargin

  private lazy val INSERT =
    """
      | INSERT INTO bookings(
      | id
      | , seat
      | , booker_name
      | , info)
      | VALUES(
      | ?
      | , ?
      | , ?
      | , ?);
    """.stripMargin

}
