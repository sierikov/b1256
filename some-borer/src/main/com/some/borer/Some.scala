package com.some.borer

import io.bullet.borer.derivation.MapBasedCodecs._
sealed trait Animal
case class Dog(age: Int, name: String) extends Animal
case class Cat(weight: Double, color: String, home: String) extends Animal
case class Fish(color: String) extends Animal
case object Yeti extends Animal
object Main {
  implicit val animalCodec = {
    implicit val dogCodec  = deriveCodec[Dog]
    implicit val catCodec  = deriveCodec[Cat]
    implicit val fishCodec = deriveCodec[Fish]
    implicit val yetiCodec = deriveCodec[Yeti.type]
    deriveCodec[Animal]
  }
  def main(): Unit = {
    val animalCodec = deriveAllCodecs[Animal]
  }
}
