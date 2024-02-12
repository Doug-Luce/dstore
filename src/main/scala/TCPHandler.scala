package dstore

import akka.io.Tcp
import akka.actor.Actor
import akka.util.ByteString

class TCPHandler extends Actor {
  import Tcp._

  def receive = {
    case Received(data) =>
      // Process incoming data, for example, print it
      println("Received: " + data.utf8String)

      // Optionally, send a response
      sender() ! Write(ByteString("Hello back!\n"))

    case PeerClosed => context.stop(self)
  }
}
