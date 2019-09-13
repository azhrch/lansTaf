
name := "LansTafGen"

version := "0.1"

scalaVersion := "2.12.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
// https://mvnrepository.com/artifact/org.apache.kafka/kafka
libraryDependencies += "org.apache.kafka" %% "kafka" % "1.1.1"
// https://mvnrepository.com/artifact/org.apache.kafka/kafka-clients
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "1.1.1"
// https://mvnrepository.com/artifact/io.circe/circe-core



resolvers += Resolver.bintrayRepo("ovotech", "maven")

libraryDependencies ++= {
  val kafkaSerializationV = "0.1.23" // see the Maven badge above for the latest version
  Seq(
    "com.ovoenergy" %% "kafka-serialization-core" % kafkaSerializationV,


  //  "com.ovoenergy" %% "kafka-serialization-circe" % kafkaSerializationV, // To provide Circe JSON support


  )
}
