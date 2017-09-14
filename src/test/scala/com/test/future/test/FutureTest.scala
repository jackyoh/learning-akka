package com.test.future.test

import java.util

import akka.util.Timeout

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.postfixOps
import scala.util.Try

object ConvertString {
   def apply(str: String): String = {
     str.toUpperCase()
   }

}

object FutureTest {
  def main(args: Array[String]): Unit ={

    val list = List("aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee")

    val futures: List[Future[String]] = list.map(element => {
      Future(ConvertString.apply(element))
    })

    val resultFuture: Future[List[String]] = Future.sequence(futures)

    val result = Await.result(resultFuture.mapTo[List[String]], 0 seconds)
    result.foreach(x => println(x))

  }

}
