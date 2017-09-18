package com.test.route.test

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.routing.RoundRobinPool

class MyActor1 extends Actor {
  override def receive: Receive = {
    case x: String => {
      println(s"Receive the $x value")
    }
    case _ => {
      println("Not found the data type")
    }
  }
}

object RouteTest {
  def main(args: Array[String]): Unit ={
    val system = ActorSystem.create()
    println(system.dispatcher)

    val workerRouter: ActorRef = system.actorOf(Props.create(classOf[MyActor1]).withRouter(new RoundRobinPool(8)))

    workerRouter ! "test1"
    workerRouter ! "test2"
    workerRouter ! "test3"
    
  }

}
