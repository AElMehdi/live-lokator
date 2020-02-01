plugins {
    scala
    application
}

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

dependencies {
    implementation("org.scala-lang:scala-library:2.12.8")

    implementation("org.apache.kafka:kafka_2.13:2.4.0")

    testImplementation("junit:junit:4.12")
    testImplementation("org.scalatest:scalatest_2.12:3.0.8")

    // Need scala-xml at test runtime
    testRuntimeOnly("org.scala-lang.modules:scala-xml_2.12:1.2.0")
}

application {
    mainClassName = "live.lokator.Consumer"
}