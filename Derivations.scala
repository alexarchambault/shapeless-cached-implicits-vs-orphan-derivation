/*
 * All of these are ok

object Direct {
  import argonaut._
  import GenDecodeJsons._
      
  DecodeJson.of[CC]
  DecodeJson.of[CC2]
}

object DirectCached {
  import argonaut._
  import GenDecodeJsons._
      
  implicit val ccDecodeJson = DecodeJson.of[CC]
  implicit val cc2DecodeJson = DecodeJson.of[CC2]
}

object DirectCachedImplicitly {
  import argonaut._
  import GenDecodeJsons._
      
  implicit val ccDecodeJson = implicitly[DecodeJson[CC]]
  implicit val cc2DecodeJson = implicitly[DecodeJson[CC2]]
}
 */

object DirectCachedThe {
  import shapeless._
  import argonaut._
  import GenDecodeJsons._
      
  implicit val ccDecodeJson = the[DecodeJson[CC]]
  //implicit val cc2DecodeJson = the[DecodeJson[CC2]] // Doesn't work either
}
