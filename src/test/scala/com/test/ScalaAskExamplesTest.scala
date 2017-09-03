package com.test

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import com.akkademy.message.ScalaPongActor
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._
import akka.pattern.ask

import scala.concurrent.Await

class ScalaAskExamplesTest extends FunSpecLike with Matchers{
  val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  val pongActor = system.actorOf(Props(classOf[ScalaPongActor]))
  describe("Pong actor") {
    it("should respond with Pong") {
      val future = pongActor ? "Ping"
      val result = Await.result(future.mapTo[String], 1 second)
      assert(result == "Pong")
    }

  }

}
