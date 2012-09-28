package models

/**
 * Created with IntelliJ IDEA.
 * User: ndupont
 * Date: 28/09/12
 * Time: 14:55
 * To change this template use File | Settings | File Templates.
 */
case class ControlType (id: Long, label: String)

object ControlType{
  def all(): List[ControlType] = Nil

  def create(label: String) {}

  def delete(id: Long) {}
}