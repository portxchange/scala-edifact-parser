package com.portofrotterdam.parsers

import fastparse.P
import fastparse.SingleLineWhitespace._
import com.portofrotterdam.models._

sealed trait TagParser extends CommonParser {
  def Delimiter[_ : P]: P[Unit] = Colon
}

object TagParser extends TagParser {
  def MessageIdentificationTag[_ : P]: P[MessageIdentification] =
    P(Alphanumeric.rep(min = 1, max = 35).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 9).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 6).!.?
    ).map(MessageIdentification.tupled)

  def DateTimeTag[_ : P]: P[DateTime] =
    P(Numeric.rep(exactly = 8).!.map(_.toInt) ~
      Delimiter ~
      Numeric.rep(exactly = 4).!.map(_.toInt)
    ).map(DateTime.tupled)

  def CorrespondentTag[_ : P]: P[Correspondent] =
    P(Alphanumeric.rep(min = 1, max = 35).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 4).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 35).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 35).!.?
    ).map(Correspondent.tupled)

  def SyntaxIdentifierTag[_ : P]: P[SyntaxIdentifier] =
    P(Alpha.rep(exactly = 4).! ~
      Delimiter ~
      Alphanumeric.rep(exactly = 1).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 6).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.?
    ).map(SyntaxIdentifier.tupled)

  def MessageIdentifierTag[_ : P]: P[MessageIdentifier] =
    P(Alphanumeric.rep(min = 1, max = 6).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).!
    ).map(MessageIdentifier.tupled)

  def ModeOfTransportTag[_ : P]: P[ModeOfTransport] =
    P(Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.?
    ).map(ModeOfTransport.tupled)

  def TransportMeansTag[_ : P]: P[TransportMeans] =
    P(Alphanumeric.rep(min = 1, max = 8).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.?
    ).map(TransportMeans.tupled)

  def CarrierTag[_ : P]: P[Carrier] =
    P(Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 35).!.?
    ).map(Carrier.tupled)

  def TransportIdentificationTag[_ : P]: P[TransportIdentification] =
    P(Alphanumeric.rep(min = 1, max = 9).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 35).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.?
    ).map(TransportIdentification.tupled)

  def ExcessTransportationInformationTag[_ : P]: P[ExcessTransportationInformation] =
    P(Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.?
    ).map(ExcessTransportationInformation.tupled)

  // Because the reference segment only contains a single tag we flatten this into segment fields
  def ReferenceTag[_ : P]: P[(String, Option[String], Option[String], Option[String], Option[String])] =
    P(Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 70).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 6).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 9).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 6).!.?
    )

  def TextReferenceTag[_ : P]: P[TextReference] =
    P(Alphanumeric.rep(min = 1, max = 17).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.?
    ).map(TextReference.tupled)

  def TextLiteralTag[_ : P]: P[TextLiteral] =
    P(Alphanumeric.rep(min = 1, max = 512).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 512).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 512).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 512).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 512).!.?
    ).map(TextLiteral.tupled)

  def LocationIdentificationTag[_ : P]: P[LocationIdentification] =
    P(Alphanumeric.rep(min = 1, max = 25).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 17).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 256).!.?
    ).map(LocationIdentification.tupled)

  def RelatedLocationIdentificationTag[_ : P]: P[RelatedLocationIdentification] =
    P(Alphanumeric.rep(min = 1, max = 25).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 70).!.?
    ).map(RelatedLocationIdentification.tupled)

  // Because the date time period segment only contains a single tag we flatten this into segment fields
  def DateTimePeriodTag[_ : P]: P[(String, Option[String], Option[String])] =
    P(Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 35).!.? ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).!.?
    )
}
