package controllers

import play.api.mvc._
import models.ControlType
import play.api.data.Form
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {
  
  def index = Action {
//    Ok("Hello world.")
//    val set = new scala.collection.mutable.HashSet[Any]
//    set += "This is a string"  // add a string
//    set += 732                 // add a number
//    set += 'c'                 // add a character
//    set += true                // add a boolean value
//    val iter = set.iterator
//    while (iter.hasNext) {
//      println(iter.next.toString())
//    }
    Redirect(routes.Application.controlTypes)
  }

  val controlTypeForm = Form(
    "label" -> nonEmptyText
  )

  def controlTypes = Action {
    Ok(views.html.index(ControlType.all(), controlTypeForm))
  }

  def newControlType = Action {
    implicit request =>
      controlTypeForm.bindFromRequest.fold(
        errors => BadRequest(views.html.index(ControlType.all(), errors)),
        label => {
          ControlType.create(label)
          Redirect(routes.Application.controlTypes)
        }
      )
  }

  def deleteControlType(id: Long) = Action {
    ControlType.delete(id)
    Redirect(routes.Application.controlTypes)
  }
}
