package com.test

import akka.actor.Status.{Failure, Success}
import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import com.akkademy.message.ScalaPongActor
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._
import akka.pattern.ask

import scala.concurrent.{Await, Future}
import scala.util.Try

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
  describe("Future Example") {
    import scala.concurrent.ExecutionContext.Implicits.global
    it("should print to console 1") {
      (pongActor ? "Ping").onComplete({
        case x: Try[String] => println("replied with: " + x.get)
      })

    }

    it("should print to console 2") {
        (pongActor ? "Ping").onSuccess({
          case x: String => println("replied with: " + x)
        })
    }

    it("test ask Pong function") {
      val result = askPong("Ping").map(x => x.charAt(0))
      for(res <- result){
        println(res)
      }
    }

    def askPong(message: String): Future[String] = (pongActor ? message).mapTo[String]
  }



}
