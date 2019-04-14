package com.portofrotterdam

import scala.util.{Failure, Success, Try}

object Parser {
  import fastparse. { P, Parsed }

  def parse[T](content: String)(implicit parser: P[_] => P[T]): Try[T] =
    fastparse
      .parse(content, parser(_))
      .fold(
        onFailure = (x: String, y: Int, z: Parsed.Extra) => Failure(new Exception(x)),
        onSuccess = (t: T, _) => Success(t)
      )
}
