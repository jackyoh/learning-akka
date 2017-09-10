package com.test.tell.test

import akka.actor.{Actor, ActorRef, Props}

class MyActor0(myActor1: ActorRef) extends Actor {


  override def receive = {
    case x: String => {
      myActor1 ! x
    }
    case x: Int => {
      println(s"value=$x")
    }
    case _ => {
      println("Type Not found")
    }

  }
}
