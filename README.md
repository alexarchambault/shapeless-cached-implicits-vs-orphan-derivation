Try compiling with `sbt compile`.

See [shapeless#391](https://github.com/milessabin/shapeless/issues/391).

Output like:
```scala
[info] Compiling 4 Scala sources to /home/alexandre/projects/tests/shapeless-cachedImplicit-vs-orphanDerivation/target/scala-2.11/classes...
[error] /home/alexandre/projects/tests/shapeless-cachedImplicit-vs-orphanDerivation/Derivations.scala:34: could not find implicit value for parameter t: argonaut.DecodeJson[CC]
[error]   implicit val ccDecodeJson = the[DecodeJson[CC]]
[error]                                  ^
[error] /home/alexandre/projects/tests/shapeless-cachedImplicit-vs-orphanDerivation/Derivations.scala:35: could not find implicit value for parameter t: argonaut.DecodeJson[CC2]
[error]   implicit val cc2DecodeJson = the[DecodeJson[CC2]]
[error]                                   ^
[error] /home/alexandre/projects/tests/shapeless-cachedImplicit-vs-orphanDerivation/Derivations.scala:43: could not find implicit value for parameter t: argonaut.DecodeJson[CC]
[error]   implicit val ccDecodeJson: DecodeJson[CC] = cachedImplicit
[error]                                               ^
[error] /home/alexandre/projects/tests/shapeless-cachedImplicit-vs-orphanDerivation/Derivations.scala:44: could not find implicit value for parameter t: argonaut.DecodeJson[CC2]
[error]   implicit val cc2DecodeJson: DecodeJson[CC2] = cachedImplicit
[error]                                                 ^
[error] four errors found
[error] (compile:compileIncremental) Compilation failed
[error] Total time: 4 s, completed 4 juin 2015 01:40:35
```

