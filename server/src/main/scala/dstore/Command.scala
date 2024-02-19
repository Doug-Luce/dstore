package dstore

sealed trait Command[T] {
  def notFound(cmd: String) = s"Err unknown command '$cmd'"
  def execute(): T
}

final case object COMMAND_PING extends Command[String] {
  override def execute(): String = {
    "PONG"
  }
}
final case class COMMAND_NOT_FOUND(cmd: String) extends Command[String] {
  override def execute(): String = {
    notFound(cmd)
  }
}

final case class COMMAND_ECHO(cmd: String) extends Command[String] {
  override def execute(): String = {
    cmd
  }
}

object CommandParser {
  def parse(input: String): Option[Command[String]] = {
    val cmdInput = input
      .split(" ")
    val cmd = cmdInput.headOption.map(_.toLowerCase())
    val operation = cmdInput.tail

    cmd match {
      case Some("ping") => Some(COMMAND_PING)
      case Some("echo") => Some(COMMAND_ECHO(operation.mkString(" ")))
      case _            => Some(COMMAND_NOT_FOUND(input))
    }
  }
}
