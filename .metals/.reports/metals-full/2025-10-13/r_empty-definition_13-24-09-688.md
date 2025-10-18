error id: file://<WORKSPACE>/build.sbt:`<none>`.
file://<WORKSPACE>/build.sbt
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -sbt/Keys.scalapb.gen.
	 -scalapb/gen.
	 -scala/Predef.scalapb.gen.
offset: 189
uri: file://<WORKSPACE>/build.sbt
text:
```scala
name := """graphql-test"""
organization := "com.example"

version := "1.0-SNAPSHOT"

// 🆕 Importaciones necesarias para la configuración de ScalaPB/gRPC
import sbt.Keys._
import scalapb.ge@@n.targets.Jvm

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings( // 👈 .settings(
  
  scalaVersion := "2.13.17",

  // 🆕 CONFIGURACIÓN DEL COMPILADOR PROTOBUF
  // Esto le dice a SBT que use ScalaPB para generar código Scala a partir de los .proto
  Compile / PB.targets := Seq(
    Jvm(scalapb.gen()) -> (Compile / sourceManaged).value 
  ),
  
  libraryDependencies ++= Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test,
  
    // Dependencias de GraphQL (Sangria/Circe) actualizadas
    "org.sangria-graphql" %% "sangria" % "4.0.0",
    "org.sangria-graphql" %% "sangria-circe" % "1.3.2",
    "io.circe" %% "circe-core" % "0.14.6",
    "io.circe" %% "circe-parser" % "0.14.6",
    
    // Dependencia de Parboiled
    "org.parboiled" %% "parboiled" % "2.5.1",
    
    // Dependencias de gRPC / SCALAPB
    "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
    "io.grpc" % "grpc-netty" % "1.60.0"
  ),
  
  // Dependencia del runtime de Google Protobuf
  libraryDependencies += "com.google.protobuf" % "protobuf-java" % "3.25.1"

  // Adds additional packages into Twirl
  //TwirlKeys.templateImports += "com.example.controllers._"

  // Adds additional packages into conf/routes
  // play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

) // 👈 Cierre del bloque .settings
```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.