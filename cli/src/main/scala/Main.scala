package dstore
import java.net.Socket
import java.net.Socket
import scala.io.StdIn
import java.io.PrintWriter
import java.io.BufferedReader
import java.io.InputStreamReader

object CLI extends App {
  val socket = new Socket("localhost", 6667)
  println("Connection successful")
  var continue = true
  val inputPrompt = "DStore>"
  val EXIT_COMMAND = "exit"

  val inputReader = new BufferedReader(
    new InputStreamReader(socket.getInputStream())
  )

  try {
    while (continue) {
      print(inputPrompt)
      val userInput = StdIn.readLine()
      if (userInput.toLowerCase == EXIT_COMMAND) {
        continue = false
      } else {
        val out = new PrintWriter(socket.getOutputStream, true)
        out.println(userInput)
        
        val in = inputReader.readLine() 
        in.flush()
        println(in)
      }
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    socket.close()
    println("Connection closed")
  }
}
