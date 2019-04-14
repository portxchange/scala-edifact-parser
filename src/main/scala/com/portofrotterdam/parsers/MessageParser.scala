package com.portofrotterdam.parsers

import com.portofrotterdam.models.IFTSAIMessage
import fastparse._

object MessageParser {

  implicit def iftsai[_ : P]: P[IFTSAIMessage] = ???
}
