name := """micro-service-scala"""
organization := "th.or.jug"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += "in.norbor" %% "yoda-orm" % "2.0"
libraryDependencies += "org.postgresql" % "postgresql" % "42.1.3"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.6"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "th.or.jug.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "th.or.jug.binders._"
