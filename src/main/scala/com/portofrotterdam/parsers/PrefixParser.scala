package com.portofrotterdam.parsers

import fastparse.{ P, StringIn }

trait PrefixParser {
  def InterchangeHeaderPrefix[_ : P]: P[Unit] = P(StringIn("UNB"))
  def MessageHeaderPrefix[_ : P]: P[Unit] = P(StringIn("UNH"))
  def BeginningOfMessagePrefix[_ : P]: P[Unit] = P(StringIn("BGM"))
  def TransportInformationPrefix[_ : P]: P[Unit] = P(StringIn("TDT"))
  def ReferencePrefix[_ : P]: P[Unit] = P(StringIn("RFF"))
  def FreeTextPrefix[_ : P]: P[Unit] = P(StringIn("FTX"))
  def LocationPrefix[_ : P]: P[Unit] = P(StringIn("LOC"))
  def DateTimePeriodPrefix[_ : P]: P[Unit] = P(StringIn("DTM"))
  def MessageTrailerPrefix[_ : P]: P[Unit] = P(StringIn("UNT"))
}
