package dstore

import java.net.ServerSocket
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Random
import java.net.InetSocketAddress
import dstore.utils.Connection

object Main extends App {
  println("Server started")
  val connection = Connection()
  var continue = true

  try {
    while (continue) {
      val message = connection.read()
      if (message == "exit") {
        continue = false
      } else {
        println(message)
        // val test = CommandParser.parse(message)
        connection.write("Ack!")
      }
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    connection.socket.close()
    connection.server.close()
    println("Server closed")
  }
}
