package com.portofrotterdam.parsers

import fastparse._
import com.portofrotterdam.parsers.SegmentParser._
import org.scalatest.{ Matchers, WordSpec }
import scala.reflect.{ classTag, ClassTag }

class SegmentParserSpec extends WordSpec with Matchers {

  def segmentTest[T: ClassTag](content: => String, parser: P[_] => P[T]) {
    s"${classTag[T].runtimeClass.getSimpleName} segment" should {
      "be able to parse content successfully" in {
        val result = parse(content, parser)

        result shouldBe a[Parsed.Success[_]]
      }
    }
  }

  segmentTest("UNB+UNOA:2+HYUNDAI+PORTOFROTTERDAM+20190101:0100+1'", InterchangeHeaderSegment(_))
  segmentTest("UNH+VIFTSAI0000001+IFTSAI:D:99B:UN'", MessageHeaderSegment(_))
  segmentTest("BGM+TS2+VIFTSAI0000001+9'", BeginningOfMessageSegment(_))
  segmentTest("TDT+20+JMDS905W+1++:172+++OWJG2:103::MADISON MAERSK'", TransportInformationSegment(_))
  segmentTest("RFF+SSX:JMDS905W'", ReferenceSegment(_))
  segmentTest("FTX+AAI+++HMM'", FreeTextSegment(_))
  segmentTest("LOC+9+NLRTM:139:6'", LocationSegment(_))
  segmentTest("DTM+132:201903070711:203'", DateTimePeriodSegment(_))
  segmentTest("UNT+27+VIFTSAI0000001'", MessageTrailerSegment(_))
}
