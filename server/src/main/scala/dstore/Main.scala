package dstore

import dstore.utils.Connection

import java.io.{
  BufferedReader,
  BufferedWriter,
  InputStreamReader,
  OutputStreamWriter
}
import java.net.{InetSocketAddress, ServerSocket}
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Random
import scala.concurrent.Future
import scala.io.StdIn

object Main extends App {
  println("Server started")
  Connection.startServer()
}
