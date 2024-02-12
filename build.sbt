// import Dependencies._

ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.dougluce.dstore"
ThisBuild / organizationName := "dstore"

val AkkaVersion = "2.9.0"
val AkkaHttpVersion = "10.6.0"
val akkaHttp = "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
val akkaActor = "com.typesafe.akka" %% "akka-actor" % AkkaVersion

resolvers += "Akka library repository".at("https://repo.akka.io/maven")

lazy val root = (project in file("."))
  .settings(
    name := "",
    libraryDependencies ++= Seq(
      akkaHttp,
      akkaActor
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
