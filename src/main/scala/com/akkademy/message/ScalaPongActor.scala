package com.akkademy.message

import akka.actor.{Actor, Status}

class ScalaPongActor extends Actor{

  override def receive = {
    case "Ping" => sender() ! "Pong"
    case _ =>
      sender() ! Status.Failure(new Exception("unknown message"))
  }
}
