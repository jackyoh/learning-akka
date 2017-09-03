package com.test

import akka.actor.{ActorRef, ActorSystem, Props}
import com.akkademy.message.{AkkademyDB, ScalaPongActor, SetRequest}

import scala.concurrent.Await
import akka.util.Timeout

import scala.concurrent.duration._
import akka.pattern.ask
import org.scalatest.{FunSpecLike, Matchers}

class ActorTest extends FunSpecLike with Matchers {
  implicit val timeout = Timeout(5 seconds)

  describe("actor test") {
    it("should respond with Pong") {
      val actorSystem = ActorSystem()
      val actor: ActorRef = actorSystem.actorOf(props())
      val future = actor ? "Ping"
      val result = Await.result(future.mapTo[String], 1 second)
      assert(result == "Pong")
    }
  }

  def props(): Props = {
    Props(classOf[ScalaPongActor])
  }

}
