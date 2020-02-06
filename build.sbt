ThisBuild / scalaVersion := "2.13.1-bin-abcd123"

ThisBuild / resolvers += "scala-integration" at
  "https://scala-ci.typesafe.com/artifactory/scala-integration/"

ThisBuild / organization := "com.aelmehdi"

lazy val liveLokator = (project in file("."))
  .settings(
    name := "live-lokator",
    libraryDependencies += "org.apache.kafka" %% "kafka" % "2.4.0",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test",
    resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases",
    addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3"),
    libraryDependencies += "org.junit.platform" % "junit-platform-runner" % "1.0.0-M3" % "test",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.0.0-M3" % "test",
    libraryDependencies += "org.junit.vintage" % "junit-vintage-engine" % "4.12.0-M3" % "test",
    libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.5.6"

  )

