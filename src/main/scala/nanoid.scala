package com.dallaway.nanoid

import scala.collection.immutable.ArraySeq
import java.{util => ju}

final case class NanoID(value: String) extends AnyVal

object alphabet {

  val `A-Za-z0-9_-` : Alphabet = Alphabet(
    "_-" +
      "0123456789" +
      "abcdefghijklmnopqrstuvwxyz" +
      "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  )

  final case class Alphabet(str: String) {
    val len: Int = str.size
    val chars: ArraySeq[Char] = ArraySeq.empty ++ str.toCharArray()
    val mask: Int =
      (2 << Math.floor(Math.log(len - 1) / Math.log(2)).intValue()) - 1
  }

}

object generator {

  import alphabet.Alphabet

  type Generator = ju.Random => (NanoID, ju.Random)

  def apply(alphabet: Alphabet, idLength: Int): Generator = {
    val stepSize: Int =
      Math.ceil(1.6 * alphabet.mask * idLength / alphabet.len).intValue()

    rng => {

      def step1(): String = {
        val bytes = new Array[Byte](stepSize)
        rng.nextBytes(bytes)
        bytes.map(i => alphabet.chars(i & alphabet.mask)).mkString
      }

      def step(charsRequired: Int, acc: String = ""): String =
        if (charsRequired < 1) acc.take(idLength)
        else {
          val next = step1()
          step(charsRequired - next.length(), acc + next)
        }

      (NanoID(step(idLength)), rng)
    }
  }

}
