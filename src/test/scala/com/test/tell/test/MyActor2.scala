package com.test.tell.test

import akka.actor.Actor

class MyActor2 extends Actor{
  override def receive = {
    case x: String => {
      println(x)
      sender() ! x
    }
    case _ => {
      println("Receive error")
    }

  }
}
