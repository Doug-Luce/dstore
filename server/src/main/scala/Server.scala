package dstore

import akka.io.{IO, Tcp}
import akka.actor.{Actor, ActorRef, Props}
import akka.util.ByteString
import java.net.InetSocketAddress

class Server extends Actor {
  import Tcp._
  import context.system

  IO(Tcp) ! Bind(self, new InetSocketAddress("localhost", 6667))

  def receive: Receive = {
    case b @ Bound(localAddress) =>
      context.parent ! b

    case CommandFailed(_:Bind) => context.stop(self)

    case c @ Connected(remote, local) => 
      val handler = context.actorOf(Props[TCPHandler]())
      val connection = sender()
      connection ! Register(handler)
  }
 
}
