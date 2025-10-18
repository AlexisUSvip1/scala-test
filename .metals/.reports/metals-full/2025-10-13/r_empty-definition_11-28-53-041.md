error id: file://<WORKSPACE>/build.sbt:
file://<WORKSPACE>/build.sbt
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -scalaVersion.
	 -scalaVersion#
	 -scalaVersion().
	 -scala/Predef.scalaVersion.
	 -scala/Predef.scalaVersion#
	 -scala/Predef.scalaVersion().
offset: 172
uri: file://<WORKSPACE>/build.sbt
text:
```scala
name := "graphql-test"
organization := "com.example"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.17"

@@scalaVersion := "2.13.17"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test,

  // Sangria y Circe compatibles con Scala 2.13
  "org.sangria-graphql" %% "sangria" % "2.0.1",
  "org.sangria-graphql" %% "sangria-circe" % "1.2.0",
  "io.circe" %% "circe-core" % "0.12.3",
  "io.circe" %% "circe-parser" % "0.12.3",

  // Parboiled compatible con Scala 2.13
  "org.parboiled" %% "parboiled" % "2.3.0",
  "org.parboiled" %% "parboiled2" % "2.3.0"
)



// Adds additional packages into Twirl templates
// TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

```


#### Short summary: 

empty definition using pc, found symbol in pc: 