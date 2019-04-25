package com.portofrotterdam.parsers

import fastparse.{ CharIn, P }

trait CommonParser {
  def Alpha[_: P]: P[Unit] = P(CharIn("a-zA-Z"))
  def Numeric[_ : P]: P[Unit] = P(CharIn("0-9"))
  def Alphanumeric[_ : P]: P[Unit] = P(Alpha | Numeric)
  def Colon[_ : P]: P[Unit] = P(CharIn(":"))
  def Plus[_ : P]: P[Unit] = P(CharIn("+"))
}
