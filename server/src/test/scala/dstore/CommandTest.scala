package dstore

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import dstore._

class CommandTest extends AnyFunSuite with Matchers {
  test("COMMAND_PING should return PONG") {
    val pingCommand = COMMAND_PING
    pingCommand.execute() should be("PONG")
  }

  test("COMMAND_NOT_FOUND should return error message") {
    val commandNotFound = COMMAND_NOT_FOUND("unknown")
    commandNotFound.execute() should be("Err unknown command 'unknown'")
  }

  test("COMMAND_ECHO should return the same string passed to it") {
    val echoCommand = COMMAND_ECHO("hello world")
    echoCommand.execute() should be("hello world")
  }

  test("CommandParser should return COMMAND_PING for 'ping' input") {
    val parsedCommand = CommandParser.parse("ping")
    parsedCommand shouldBe Some(COMMAND_PING)
  }

  test("CommandParser should return COMMAND_ECHO for 'echo' input") {
    val parsedCommand = CommandParser.parse("echo hello world")
    parsedCommand should matchPattern { case Some(COMMAND_ECHO("hello world")) => }
  }

  test("CommandParser should return COMMAND_NOT_FOUND for unknown commands") {
    val parsedCommand = CommandParser.parse("unknown command")
    parsedCommand should matchPattern { case Some(COMMAND_NOT_FOUND("unknown command")) => }
  }
}
