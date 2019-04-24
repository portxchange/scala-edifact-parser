package models

case class InterchangeHeader(
  identifier: SyntaxIdentifier,
  sender: Correspondent,
  recipient: Correspondent,
  dateTime: DateTime,
  controlReference: String
)

case class MessageHeader(
  referenceNumber: String,
  identifier: MessageIdentifier
)

case class BeginningOfMessage(
  name: String,
  messageIdentification: MessageIdentification,
  functionCode: Option[String]
)

case class TransportInformation(
  stageCode: String,
  journeyIdentifier: Option[String],
  modeOfTransport: Option[ModeOfTransport],
  transportMeans: Option[TransportMeans],
  carrier: Option[Carrier],
  transitDirectionIndicatorCode: Option[String],
  excessTransportationInformation: Option[ExcessTransportationInformation],
  transportIdentification: Option[TransportIdentification],
)

case class Reference(
  codeQualifier: String,
  identifier: Option[String],
  documentLineIdentifier: Option[String],
  versionIdentifier: Option[String],
  revisionIdentifier: Option[String]
)

case class FreeText(
  subjectCode: String,
  functionCode: Option[String],
  reference: Option[TextReference],
  literal: Option[TextLiteral],
  languageNameCode: Option[String],
  formatCode: Option[String]
)

case class Location(
  codeQualifier: String,
  identification: LocationIdentification,
  firstRelatedIdentification: Option[RelatedLocationIdentification],
  secondRelatedIdentification: Option[RelatedLocationIdentification]
)

case class DateTimePeriod(
  functionCodeQualifier: String,
  text: Option[String],
  formatCode: Option[String]
)

case class MessageTrailer(
  numberOfSegments: Int,
  referenceNumber: String
)
