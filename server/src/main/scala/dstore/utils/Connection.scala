package dstore.utils

import java.net.{ServerSocket, Socket}
import java.io.{
  BufferedReader,
  BufferedWriter,
  InputStreamReader,
  OutputStreamWriter
}

class Connection(
    val server: ServerSocket,
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
}

object Connection {
  private val PORT = 6667
  private val MAX_CONNECTION_QUEUE = 10

  def apply(): Connection = {
    val server = new ServerSocket(PORT, MAX_CONNECTION_QUEUE)
    println(s"Server port: ${server.getLocalPort()}")
    val socket = server.accept()

    val inputStream = new BufferedReader(
      new InputStreamReader(socket.getInputStream)
    )
    val outputStream = new BufferedWriter(
      new OutputStreamWriter(socket.getOutputStream)
    )

    new Connection(server, socket, inputStream, outputStream)
  }
}
