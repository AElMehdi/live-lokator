ThisBuild / scalaVersion := "2.12.7"

ThisBuild / organization := "com.aelmehdi"

lazy val liveLokator = (project in file("."))
  .settings(
    name := "live-lokator",
    libraryDependencies += "org.apache.kafka" %% "kafka" % "2.4.0",
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test",
    libraryDependencies += "org.apache.kafka" % "kafka-streams-test-utils" % "2.4.0" % Test,
    resolvers += "Artima Maven Repository" at "https://repo.artima.com/releases",
    addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3"),
    libraryDependencies += "org.junit.platform" % "junit-platform-runner" % "1.0.0-M3" % "test",
    libraryDependencies += "org.junit.jupiter" % "junit-jupiter-engine" % "5.0.0-M3" % "test",
    libraryDependencies += "org.junit.vintage" % "junit-vintage-engine" % "4.12.0-M3" % "test",
    libraryDependencies += "org.apache.zookeeper" % "zookeeper" % "3.5.6"

  )

