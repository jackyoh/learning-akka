package com.test.tell.test

import akka.actor.{ActorSystem, Props}

object Client {

  def main(args: Array[String]) = {
    val actorSystem = ActorSystem.create()
    val myActor2 = actorSystem.actorOf(Props(classOf[MyActor2]), "actor2")
    val myActor1 = actorSystem.actorOf(Props(classOf[MyActor1], myActor2.path.toString()), "actor1")
    val myActor0 = actorSystem.actorOf(Props(classOf[MyActor0], myActor1), "actor0")
    myActor0 ! "TEST123"
  }
}
