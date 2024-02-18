package dstore

object CommandParser {
  def parse(input: String): Option[Command] = input match {
    case "ping" => Some(COMMAND_PING)
  }
}
