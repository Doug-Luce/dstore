package dstore

import java.net.ServerSocket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Random

object Main extends App {
  println("Server started")
  val server = new ServerSocket(6667)
  var continue = true
  val socket = server.accept()

  val inputStream = new BufferedReader(
    new InputStreamReader(socket.getInputStream)
  )

  val outputStream = new BufferedWriter(
    new OutputStreamWriter(socket.getOutputStream)
  )

  try {
    while (continue) {
      val message = inputStream.readLine()
      if (message == null || message == "exit") {
        continue = false
      } else {
        println(message)
        outputStream.write("test \n")
        outputStream.flush()
      }
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    socket.close()
    server.close()
    println("Server closed")
  }
}
