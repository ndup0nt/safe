package models

import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

/**
 * Created with IntelliJ IDEA.
 * User: ndupont
 * Date: 28/09/12
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
case class ControlType (id: Long, label: String)

object ControlType{

  val controlTypeParser = {
    get[Long]("id") ~
    get[String]("label") map {
      case id~label => ControlType(id, label)
    }
  }

  def all(): List[ControlType] = DB.withConnection { implicit c =>
    SQL("select * from controlType").as(controlTypeParser *)
  }

  def create(label: String) {
    DB.withConnection { implicit c =>
      SQL("insert into controlType (label) values ({label})").on(
        'label -> label
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from controlType where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }
}