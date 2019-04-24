import fastparse.P
import parsers.MessageParser
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
}

case class ParseException(message: String, index: Int) extends Exception(message)
