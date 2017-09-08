package com.test

import akka.actor.{ActorRef, ActorSystem, Props}
import com.akkademy.message.ImmutableMessage

object MyClientActorTest {

  def main(args: Array[String]) = {
    val actorSystem = ActorSystem.create()
    val actor: ActorRef = actorSystem.actorOf(Props(classOf[MyActorTest1]), "myactor")
    actor ! ImmutableMessage("hello world")

  }

}
