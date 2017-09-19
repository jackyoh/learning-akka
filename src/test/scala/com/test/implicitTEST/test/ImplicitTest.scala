package com.test.implicitTEST.test

case class PreferredPrompt(preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt): Unit ={
    println("Welcome, " + name + ". The System is ready.")
    println(prompt.preference)
  }

}

object ImplicitTest {

  def main(args: Array[String]): Unit ={
    val bobsPrompt = new PreferredPrompt("relax")
    implicit val prompt1 = new PreferredPrompt("hello")
    Greeter.greet("Bob")

  }
}
