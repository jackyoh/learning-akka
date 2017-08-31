package com.akkademy.message
import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{FunSpecLike, Matchers}

class AkkademyDbSpec extends FunSpecLike with Matchers{
   implicit val system = ActorSystem()

   describe("akkademyDb") {
     it("should place key/value into map") {
       val actorRef = TestActorRef(new AkkademyDB)
       actorRef ! SetRequest("key", "value1")

       val akkademyDb = actorRef.underlyingActor
       akkademyDb.map.get("key") should equal(Some("value"))
     }

   }
}
