package com.portofrotterdam.parsers

import fastparse._
import fastparse.SingleLineWhitespace._

trait Parser {
  def alpha[_ : P]: P[Unit] = P(StringIn("A-B"))
  def numeric[_ : P]: P[Unit] = P(StringIn("0-9"))
  def alphanumeric[_ : P]: P[Unit] = P(alpha | numeric)
}
