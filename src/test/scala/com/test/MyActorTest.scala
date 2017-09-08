package com.test

import akka.actor.{Actor, Props}
import com.akkademy.message.ImmutableMessage

class MyActorTest1 extends Actor {
  override def receive: Receive = {

    case ImmutableMessage(message) => {
      val actor = context.actorOf(Props[MyActorTest2])
      actor ! "Message Test 1"
      actor ! "Message Test 2"
      actor ! "Message Test 3"
    }

    case str: String => {
      println(s"RECECIVE THE $str VALUE.")
    }

    case _ => {
      "Message receive error"
    }
  }
}

class MyActorTest2 extends Actor {
  override def receive: Receive = {
    case str: String => {
      sender() ! "MyActorTest2 " + str.toUpperCase()
    }
  }
}