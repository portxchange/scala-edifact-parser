package com.portofrotterdam.parsers

import fastparse.{ CharIn, P }
import fastparse.SingleLineWhitespace._
import com.portofrotterdam.models._
import com.portofrotterdam.parsers.TagParser._

sealed trait SegmentParser extends CommonParser {
  def Delimiter[_ : P]: P[Unit] = Plus
  def EndOfLine[_: P]: P[Unit] = P(CharIn("'"))
}

object SegmentParser extends SegmentParser with PrefixParser {

  def InterchangeHeaderSegment[_ : P]: P[InterchangeHeader] =
    P(InterchangeHeaderPrefix ~
      Delimiter ~
      SyntaxIdentifierTag ~
      Delimiter ~
      CorrespondentTag ~
      Delimiter ~
      CorrespondentTag ~
      Delimiter ~
      DateTimeTag ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 14).! ~
      EndOfLine
    ).map(InterchangeHeader.tupled)

  def MessageHeaderSegment[_ : P]: P[MessageHeader] =
    P(MessageHeaderPrefix ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 14).! ~
      Delimiter ~
      MessageIdentifierTag ~
      EndOfLine
    ).map(MessageHeader.tupled)

  def BeginningOfMessageSegment[_ : P]: P[BeginningOfMessage] =
    P(BeginningOfMessagePrefix ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter ~
      MessageIdentificationTag ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      EndOfLine
    ).map(BeginningOfMessage.tupled)

  //FIXME None exhaustive parser
  def TransportInformationSegment[_ : P]: P[TransportInformation] =
    P(TransportInformationPrefix ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 17).!.? ~
      Delimiter.? ~
      ModeOfTransportTag.? ~
      Delimiter.? ~
      TransportMeansTag.? ~
      Delimiter.? ~
      CarrierTag.? ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter ~
      ExcessTransportationInformationTag.? ~
      Delimiter ~
      TransportIdentificationTag.? ~
      EndOfLine
    ).map(TransportInformation.tupled)

  def ReferenceSegment[_ : P]: P[Reference] =
    P(ReferencePrefix ~
      Delimiter ~
      ReferenceTag
    ).map(Reference.tupled)

  def FreeTextSegment[_ : P]: P[FreeText] =
    P(FreeTextPrefix ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      TextReferenceTag.? ~
      Delimiter.? ~
      TextLiteralTag.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.? ~
      Delimiter.? ~
      Alphanumeric.rep(min = 1, max = 3).!.?
    ).map(FreeText.tupled)

  def LocationSegment[_ : P]: P[Location] =
    P(LocationPrefix ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 3).! ~
      Delimiter ~
      LocationIdentificationTag ~
      Delimiter.? ~
      RelatedLocationIdentificationTag.? ~
      Delimiter.? ~
      RelatedLocationIdentificationTag.? ~
      EndOfLine
    ).map(Location.tupled)

  def DateTimePeriodSegment[_ : P]: P[DateTimePeriod] =
    P(DateTimePeriodPrefix ~
      Delimiter ~
      DateTimePeriodTag ~
      EndOfLine
    ).map(DateTimePeriod.tupled)

  def MessageTrailerSegment[_ : P]: P[MessageTrailer] =
    P(MessageTrailerPrefix ~
      Delimiter ~
      Numeric.rep(min = 1, max = 10).!.map(_.toInt) ~
      Delimiter ~
      Alphanumeric.rep(min = 1, max = 14).!
    ).map(MessageTrailer.tupled)
}
