package com.test.state.test

import akka.actor.{Actor, ActorSystem, Props, Stash}


case class Connected()
case class Disconnected()

class StateActor extends Actor with Stash{

  override def receive: Receive = {
    case x: String => {
      stash()
    }
    case _: Connected => {
      unstashAll()
      context.become(online)
    }
  }

  def online: Receive = {
    case x: Disconnected => {
      println("Disconnected")
      context.unbecome()
    }
    case x: String => {
      println(x)
    }
  }
}

object StateClient {
  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem.create()
    val actor = actorSystem.actorOf(Props(classOf[StateActor]), "stateActor")

    actor ! Disconnected()
    actor ! "HELLO WORLD 1"
    actor ! Connected()
    actor ! Disconnected()
    actor ! "HELLO WORLD 2"
    actor ! "HELLO WORLD 3"
    actor ! Connected()
    actor ! "HELLO WORLD 4"
    actor ! "HELLO WORLD 5"
  }
}