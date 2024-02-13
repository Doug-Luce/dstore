package dstore
import java.net.Socket
import java.net.InetSocketAddress
import java.io.DataInputStream
import java.io.DataOutputStream

object CLI extends App {
  val socket = new Socket()
  socket.connect(new InetSocketAddress("localhost", 6667))
  val dataIn = new DataInputStream(socket.getInputStream())
  val dataOut = new DataOutputStream(socket.getOutputStream())
  dataOut.writeUTF("Hello, this is coming from the client")
  val response = dataIn.readUTF()
  println(response)
  dataIn.close()
  dataOut.close()
  socket.close()

  println("Connection successful")

}
