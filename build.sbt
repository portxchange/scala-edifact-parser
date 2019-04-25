lazy val `scala-edifact-parser` = project in file(".")

name := "scala-edifact-parser"
organization := "com.portofrotterdam"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.lihaoyi"   %% "fastparse" % "2.1.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)

bintrayOrganization := Some("port-of-rotterdam")
bintrayPackage := "scala-edifact-parser"

licenses += ("MIT", url("https://opensource.org/licenses/MIT"))
