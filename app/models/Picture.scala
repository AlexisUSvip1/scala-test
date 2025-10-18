package models


case class Picture(id: String, width: Int, height: Int, url: Option[String]) extends Identifiable