name := "scala-edifact-parser"

organization := "com.portofrotterdam"

version := "0.0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.lihaoyi"   %% "fastparse" % "2.1.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)
