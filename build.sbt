ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.dougluce.dstore"
ThisBuild / organizationName := "dstore"

val AkkaVersion = "2.9.0"
val AkkaHttpVersion = "10.6.0"
val akkaHttp = "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
val akkaActor = "com.typesafe.akka" %% "akka-actor" % AkkaVersion

resolvers in ThisBuild += "Akka library repository" at "https://repo.akka.io/maven"
val commonSettings = Seq(libraryDependencies ++= Seq(akkaHttp, akkaActor))

lazy val server = (project in file("server")).settings(commonSettings)
lazy val cli = (project in file("cli")).settings(commonSettings)

