name := "nanoid"

version := "2.0.0"

scalaVersion := "2.13.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-Ywarn-dead-code",
  "-Xlint",
  "-Ywarn-value-discard",
  "-Xfatal-warnings",
)

libraryDependencies += "org.scalameta" %% "munit" % "0.5.2"

testFrameworks += new TestFramework("munit.Framework")

