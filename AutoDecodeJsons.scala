trait AutoDecodeJsons {
  import argonaut._
  import scalaz.Scalaz.{^ => apply2, _}
  import shapeless._, labelled.{ FieldType, field }


  object DecodeJsonDeriver {

  implicit val hnilDecodeJson: DecodeJson[HNil] =
    DecodeJson { c =>
      (HNil: HNil).point[DecodeResult]
    }

  implicit def hconsDecodeJson[K <: Symbol, H, T <: HList](implicit
    key: Witness.Aux[K],
    headDecode: Lazy[DecodeJson[H]],
    tailDecode: Lazy[DecodeJson[T]]
  ): DecodeJson[FieldType[K, H] :: T] =
    DecodeJson { c =>
      val headJson = c --\ key.value.name
      val head = headJson.as(headDecode.value).map(field[K](_))
      lazy val tail = headJson.delete.as(tailDecode.value)
      apply2(head, tail)(_ :: _)
    }

  implicit def projectDecodeJson[F, G](implicit
    gen: LabelledGeneric.Aux[F, G],
    decode: Lazy[DecodeJson[G]]
  ): DecodeJson[F] =
    decode.value.map(gen.from)

  }


  implicit def decodeJsonDeriver[T](implicit orphan: Orphan[DecodeJson, DecodeJsonDeriver.type, T]): DecodeJson[T] =
    orphan.instance

}

object GenDecodeJsons extends AutoDecodeJsons
