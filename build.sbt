name := "playtest"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.springframework" % "spring-context" % "3.2.1.RELEASE",
  "org.springframework" % "spring-orm" % "3.2.1.RELEASE",
  "org.springframework" % "spring-jdbc" % "3.2.1.RELEASE",
  "org.springframework" % "spring-tx" % "3.2.1.RELEASE",
  "org.springframework" % "spring-expression" % "3.2.1.RELEASE",
  "org.springframework" % "spring-aop" % "3.2.1.RELEASE",
  "org.springframework" % "spring-test" % "3.2.1.RELEASE" % "test",
  "org.springframework.data" % "spring-data-hadoop" % "1.0.0.RELEASE",
  "uk.com.robust-it" % "cloning" % "1.7.4",
  "org.springframework.security" % "spring-security-config" % "3.2.1.RELEASE",
  "org.springframework.security" % "spring-security-core" % "3.2.1.RELEASE",
  "org.springframework.security" % "spring-security-openid" % "3.2.1.RELEASE",
  "org.apache.hadoop" % "hadoop-core" % "2.0.0-mr1-cdh4.0.1",
  "org.apache.hbase" % "hbase" % "0.92.1-cdh4.0.1",
  "org.apache.hadoop" % "hadoop-common" % "2.0.0-cdh4.0.1",
  "org.slf4j" % "slf4j-api" % "1.6.6",
  "org.slf4j" % "slf4j-log4j12" % "1.6.6",
  javaJdbc,
  javaEbean,
  cache
)   

play.Project.playJavaSettings
