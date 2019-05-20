package com.portofrotterdam.parsers

import com.portofrotterdam.Parser
import java.nio.file.{Files, Paths}
import org.scalatest.{Matchers, WordSpec}
import scala.collection.JavaConverters._
import scala.util.Success

class MessageParserSpec extends WordSpec with Matchers {

  "Message parser" should {

    Files
      .newDirectoryStream(Paths.get("src/test/resources/iftsai"))
      .asScala
      .foreach { path =>
        s"be able to parse IFTSAI messages - ${path.getFileName.toString}" in {
          val input = Files.readAllLines(path).asScala.mkString("")
          val result = Parser.parseIFTSAI(input)

          result shouldBe a[Success[_]]
        }
      }
  }
}
