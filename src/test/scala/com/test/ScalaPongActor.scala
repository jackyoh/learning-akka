package com.test

import akka.actor.Props
import com.akkademy.message.AkkademyDB

object ScalaPongActor {

  def props(): Props = {
    Props(classOf[AkkademyDB])
  }
}
