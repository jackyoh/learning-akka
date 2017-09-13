package com.test.lifecycle.test

import akka.actor.{Actor, ActorSystem, Kill, PoisonPill, Props}


class MyActor1 extends Actor {
  val actor2 = context.actorOf(Props(classOf[MyActor2]), "myActor2")
  context.watch(actor2)

  override def receive: Receive = {
    case x: String => {
      println(s"x value = $x")
      actor2 ! "HELLO WORLD2"
    }
    case _ => {
      println("data type not found")
    }

  }

}

class MyActor2 extends Actor {
  override def receive: Receive = {
    case y: String => {
      println(s"y value = $y")
    }
    case _ => {
      println("data type not found")
    }
  }
}

object Client {
  def main(args: Array[String]): Unit ={
    val actorSystem = ActorSystem.create()
    val actor = actorSystem.actorOf(Props(classOf[MyActor1]), "myActor1")
    actor ! "HELLO WORLD"
    actor ! PoisonPill
  }
}
