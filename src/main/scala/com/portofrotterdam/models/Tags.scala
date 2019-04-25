package com.portofrotterdam.models

case class MessageIdentification(
  message: String,
  version: Option[String],
  revision: Option[String]
)

case class Correspondent(
  identification: String,
  qualifier: Option[String],
  internalIdentification: Option[String],
  internalSubIdentification: Option[String]
)

case class DateTime(
  date: Int,
  time: Int
)

case class SyntaxIdentifier(
  identifier: String,
  versionNumber: String,
  something: Option[String],
  encoding: Option[String]
)

case class MessageIdentifier(
  `type`: String,
  versionNumber: String,
  releaseNumber: String,
  controllingAgency: String
)

case class ModeOfTransport(
  code: Option[String],
  name: Option[String]
)

case class TransportMeans(
  descriptionCode: Option[String],
  identificationCode: Option[String],
  agencyCode: Option[String],
  description: Option[String]
)

case class Carrier(
  identifier: Option[String],
  identificationCode: Option[String],
  agencyCode: Option[String],
  name: Option[String]
)

case class TransportIdentification(
  nameIdentifier: Option[String],
  identificationCode: Option[String],
  agencyCode: Option[String],
  name: Option[String],
  nationalityCode: Option[String]
)

case class ExcessTransportationInformation(
  reasonCode: String,
  responsibilityCode: String,
  authorisationIdentifier: Option[String]
)

case class TextReference(
  descriptionCode: String,
  identificationCode: Option[String],
  agencyCode: Option[String]
)

case class TextLiteral(
  part1: String,
  part2: Option[String],
  part3: Option[String],
  part4: Option[String],
  part5: Option[String]
)

case class LocationIdentification(
  nameCode: String,
  identificationCode: String,
  agencyCode: String,
  locationName: Option[String]
)

case class RelatedLocationIdentification(
  nameCode: Option[String],
  identificationCode: Option[String],
  agencyCode: Option[String],
  locationName: Option[String]
)
