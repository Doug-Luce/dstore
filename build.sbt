ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.dougluce.dstore"
ThisBuild / organizationName := "dstore"
lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "3.2.9" % Test,
    "org.mockito" % "mockito-core" % "3.11.2" % Test
  )
)
lazy val server = (project in file("server")).settings(commonSettings)
lazy val cli = (project in file("cli")).settings(commonSettings)
