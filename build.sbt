ThisBuild / scalaVersion := "2.13.12"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.dougluce.dstore"
ThisBuild / organizationName := "dstore"


lazy val server = (project in file("server"))
lazy val cli = (project in file("cli"))
