package dstore

sealed trait Command[T] {
  def notFound(cmd: String) = s"Err unknown command '$cmd'"
  def execute(): T
}
case object COMMAND_PING extends Command[String] {
  override def execute(): String = {
    "PONG"
  }
}
case class COMMAND_NOT_FOUND(cmd: String) extends Command[String] {
  override def execute(): String = {
    notFound(cmd)
  }
}

object CommandParser {
  def parse(input: String): Option[Command[String]] = input match {
    case "ping" => Some(COMMAND_PING)
    case _      => Some(COMMAND_NOT_FOUND(input))
  }
}
