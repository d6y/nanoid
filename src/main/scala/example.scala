object Example {
  def main(args: Array[String]): Unit = {
    import com.dallaway.nanoid
    val generator = nanoid.generator(nanoid.alphabet.`A-Za-z0-9_-`, 21)

    import java.security.SecureRandom
    val rand1 = new SecureRandom()

    val (id, rand2) = generator(rand1)
    println(id)
  }
}
