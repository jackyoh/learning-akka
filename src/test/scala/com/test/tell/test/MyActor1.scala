package com.test.tell.test

import akka.actor.{Actor, ActorRef, Props}

class MyActor1(myActor2Path: String) extends Actor{
  val myActor2 = context.actorSelection(myActor2Path)

  override def receive = {
    case x: String => {
      val senderRef = sender()
      val extraActor = buildExtraActor(senderRef)
      myActor2.tell("Hello MyActor3", extraActor)
    }
    case _ => {
      println("Receive error")
    }
  }


  def buildExtraActor(senderRef: ActorRef): ActorRef = {
    return context.actorOf(Props(new Actor {
      override def receive = {
        case x: String => {
          println(senderRef.path)
          senderRef ! 111
          //context.stop(self)
        }
      }
    }))
  }
}
