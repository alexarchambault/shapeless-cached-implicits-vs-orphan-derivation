/*
 * All of these are ok

object DirectNoOrphans {
  import argonaut._
  import GenDecodeJsons.DecodeJsonDeriver._
      
  DecodeJson.of[CC]
  DecodeJson.of[CC2]
}

object DirectCachedNoOrphans {
  import argonaut._
  import GenDecodeJsons.DecodeJsonDeriver._
      
  implicit val ccDecodeJson = DecodeJson.of[CC]
  implicit val cc2DecodeJson = DecodeJson.of[CC2]
}

object DirectCachedImplicitlyNoOrphans {
  import argonaut._
  import GenDecodeJsons.DecodeJsonDeriver._
      
  implicit val ccDecodeJson = implicitly[DecodeJson[CC]]
  implicit val cc2DecodeJson = implicitly[DecodeJson[CC2]]
}
 */

object DirectCachedTheNoOrphans {
  import shapeless._
  import argonaut._
  import GenDecodeJsons.DecodeJsonDeriver._
      
  implicit val ccDecodeJson = the[DecodeJson[CC]]
  implicit val cc2DecodeJson = the[DecodeJson[CC2]]
}

object CachedNoOrphans {
  import shapeless._
  import argonaut._
  import GenDecodeJsons.DecodeJsonDeriver._
      
  implicit val ccDecodeJson: DecodeJson[CC] = cachedImplicit
  implicit val cc2DecodeJson: DecodeJson[CC2] = cachedImplicit
}
