package com.portofrotterdam.models

import com.portofrotterdam.parsers.IFTSAIMessageParser
import fastparse.P

case class IFTSAIMessage(
  interchangeHeader: Option[InterchangeHeader],
  messageHeader: MessageHeader,
  beginningOfMessage: BeginningOfMessage,
  dateTimePeriod: Seq[DateTimePeriod],
  freeText: Seq[FreeText],
  segmentGroup4: SegmentGroup4,
  segmentGroup6: Option[SegmentGroup6],
  messageTrailer: MessageTrailer
)

object IFTSAIMessage {
  implicit val IFTSAIMessage: P[_] => P[IFTSAIMessage] = IFTSAIMessageParser.parser(_)
}

case class SegmentGroup4(
  transportInformation: TransportInformation,
  reference: Seq[Reference],
  freeText: Seq[FreeText],
  segmentGroup5: Seq[SegmentGroup5]
)

case class SegmentGroup5(
  location: Location,
  dateTimePeriod: Seq[DateTimePeriod],
  reference: Seq[Reference],
  freeText: Seq[FreeText]
)

case class SegmentGroup6(
  location: Location
)
