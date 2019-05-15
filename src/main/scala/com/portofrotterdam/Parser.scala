package com.portofrotterdam

import com.portofrotterdam.models.IFTSAIMessage
import fastparse.P
import scala.util.{ Failure, Success, Try }

object Parser {

  def parse[T](content: String)(implicit parser: P[_] => P[T]): Try[T] =
    fastparse
      .parse(content, parser(_))
      .fold(
        onFailure = (message, index, _) =>
          Failure(ParseException(message, index)),
        onSuccess = (t: T, _) =>
          Success(t)
      )

  def parseIFTSAI(content: String): Try[IFTSAIMessage] =
    parse[IFTSAIMessage](content)
}

case class ParseException(message: String, index: Int) extends Exception(message)
