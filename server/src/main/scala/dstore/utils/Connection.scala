package dstore.utils

import java.net.{ServerSocket, Socket}
import java.io.{
  BufferedReader,
  BufferedWriter,
  InputStreamReader,
  OutputStreamWriter
}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import dstore.CommandParser
import scala.io.StdIn

class Connection(
    val socket: Socket,
    val inputStream: BufferedReader,
    val outputStream: BufferedWriter
) {
  def write(message: String): Unit = {
    outputStream.write(message + "\n")
    outputStream.flush()
  }

  def read(): String = {
    val message = inputStream.readLine()

    if (message != null) message else ""
  }

  def close(): Unit = {
    socket.close()
    outputStream.close()
    inputStream.close()
  }

  def handleConnection(): Unit = {
    var serverActive = true
    while (serverActive) {
      val message = read()

      val cmdOpt = CommandParser.parse(message)
      // response to client
      cmdOpt.map(cmd => write(cmd.execute()))
    }
    close()
  }
}

object Connection {
  private val PORT = 6667
  private val MAX_CONNECTION_QUEUE = 10
  @volatile private var serverActive = true

  def startServer(): Unit = {
    val server = new ServerSocket(PORT, MAX_CONNECTION_QUEUE)
    println(s"Server listening on port: ${server.getLocalPort()}")

    Future {
      while (serverActive) {
        print("Server> ")
        val input = StdIn.readLine()
        if (input == "exit") {
          serverActive = false
          System.exit(0)
        }
      }
    }
    try {
      while (serverActive) {
        val socket = server.accept()
        Future {
          val inputStream = new BufferedReader(
            new InputStreamReader(socket.getInputStream)
          )
          val outputStream = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream)
          )
          val connection = new Connection(socket, inputStream, outputStream)
          connection.handleConnection()
          connection.close()
        }
      }
    } finally {
      server.close()
      println("Server exited.")
    }
  }
}
