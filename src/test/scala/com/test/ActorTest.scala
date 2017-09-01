package com.test

import akka.actor.{ActorRef, ActorSystem, Props}
import com.akkademy.message.{AkkademyDB, SetRequest}

object ActorTest {

  def main(args: Array[String]) = {
    val actorSystem = ActorSystem()
    val actor: ActorRef = actorSystem.actorOf(ScalaPongActor props())
    actor ! "HELLO WORLD"
    actor ! SetRequest("key1", "value1")
  }
}
