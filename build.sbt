name := "HandsOn-Akka-Actors"

version := "1.0"

scalaVersion := "2.11.8"

organization := "com.octo"

mainClass in Compile := Some("com.octo.crawler.Main")

resolvers ++= Seq(
  "Maven Central Server" at "http://repo1.maven.org/maven2"
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.8",
  "org.scalaj" %% "scalaj-http" % "1.1.0",
  "io.reactivex" %% "rxscala" % "0.25.1"
  )