# Nano ID for Scala

Scala 2 implementation of <https://github.com/ai/nanoid>

# Usage

```
import com.dallaway.nanoid
val generator = nanoid.generator(naoid.alphabet.`A-Za-z0-9_-`, 21)

import java.security.SecureRandom
val rand1 = new SecureRandom()

val (id, rand2) = generator(rand1)
println(id)
// NanoID(qVWKx3gE4vsndUGesNdTZ)

```
