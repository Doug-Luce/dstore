package dstore.utils

import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import java.io.{BufferedReader, BufferedWriter, StringWriter, StringReader}
import java.net.Socket
import org.scalatest.funsuite.AnyFunSuite

class ConnectionTest extends AnyFunSuite with Matchers {
  test("write sends a message to the output stream") {
    val socket: Socket = mock(classOf[Socket])
    val out = new StringWriter()
    val outputStream = new BufferedWriter(out)
    val inputStream = mock(classOf[BufferedReader])
    val connection = new Connection(socket, inputStream, outputStream)

    connection.write("Test Message")

    out.toString should include("Test Message\n")
  }

  test("read receives a message from the input stream") {
    val socket = mock(classOf[Socket])
    val in = new StringReader("Test Message\n")
    val inputStream = new BufferedReader(in)
    val outputStream = mock(classOf[BufferedWriter])
    val connection = new Connection(socket, inputStream, outputStream)

    val message = connection.read()

    message should be("Test Message")
  }

  test("close closes the socket and streams") {
    val socket = mock(classOf[Socket])
    val inputStream = mock(classOf[BufferedReader])
    val outputStream = mock(classOf[BufferedWriter])
    val connection = new Connection(socket, inputStream, outputStream)

    connection.close()

    verify(socket).close()
    verify(inputStream).close()
    verify(outputStream).close()
  }
}
