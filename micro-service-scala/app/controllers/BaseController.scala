package controllers

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import utilities.Json

abstract class BaseController(cc: ControllerComponents)
  extends AbstractController(cc) {

  protected def validate[Form: Manifest](action: Form => Json) = Action { implicit request: Request[AnyContent] =>
    request match {
      case _ if !request.hasBody => BadRequest("request have no body.")
      case _ if request.body.asJson.isEmpty => BadRequest("request body is not json.")
      case _ if as[Form](request).isEmpty => BadRequest("request json is invalid")
      case _ => Ok(action(as[Form](request).get).toText) as "application/json"
    }
  }

  protected def as[Object: Manifest](request: Request[AnyContent]): Option[Object] =
    Json.toObject[Object](request.body.asJson.get.toString)

  def handling(action: => Json) = Action { implicit request: Request[AnyContent] =>
    Ok(action.toText) as "application/json"
  }

}
