package dstore

import java.net.InetSocketAddress
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props


object Main extends App {
  val system = ActorSystem("TcpServerSystem")
  val serverActor = system.actorOf(Props[Server], "serverActor")

  println("server started")
}

