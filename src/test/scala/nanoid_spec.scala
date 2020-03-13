package com.dallaway.nanoid

import java.{util => ju}

class AlphabetSuite extends munit.FunSuite {
  test("default alphabets contains 64 symbols") {
    assertEquals(alphabet.`A-Za-z0-9_-`.len, 64)
  }
}

class GeneratorSuite extends munit.FunSuite {
  test("test generator with known seed and alphabet") {
    // This test mirrors https://github.com/aventrix/jnanoid/blob/develop/src/test/java/com/aventrix/jnanoid/NanoIdUtilsTest.java#L90-L109
    val rng0 = new ju.Random(12345)
    val gen = generator(alphabet.`A-Za-z0-9_-`, 21)

    val (id1, rng1) = gen(rng0)
    assertEquals(id1.value.length(), 21)
    assertEquals(id1.value, "kutqLNv1wDmIS56EcT3j7")

    val (id2, rng2) = gen(rng1)
    assertEquals(id2.value, "U497UttnWzKWWRPMHpLD7")

    val (id3, rng3) = gen(rng2)
    assertEquals(id3.value, "7nj2dWW1gjKLtgfzeI8eC")

    val (id4, rng4) = gen(rng3)
    assertEquals(id4.value, "I6BXYvyjszq6xV7L9k2A9")

    val (id5, _) = gen(rng4)
    assertEquals(id5.value, "uIolcQEyyQIcn3iM6Odoa")
  }
}
