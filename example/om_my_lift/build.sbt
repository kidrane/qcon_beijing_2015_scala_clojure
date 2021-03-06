name := "Scala, Clojure, Lift & Om"

version := "0.1.0"

organization := "dpp.rocks"

scalaVersion := "2.11.6"

resolvers ++=
  Seq("snapshots"     at "https://oss.sonatype.org/content/repositories/snapshots",
    "staging"       at "https://oss.sonatype.org/content/repositories/staging",
    "releases"      at "https://oss.sonatype.org/content/repositories/releases",
    "clojars" at "https://clojars.org/repo/"
  )

seq(webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "3.0-SNAPSHOT"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"        % liftVersion        % "compile",
  "org.clojure" % "clojure" % "1.6.0" % "compile",
    "org.eclipse.jetty" % "jetty-webapp"        % "8.1.7.v20120910"  % "container,test",
    "org.eclipse.jetty" % "jetty-plus"          % "8.1.7.v20120910"  % "container,test", // For Jetty Config
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.clojure" % "core.async" % "0.1.346.0-17112a-alpha",
    "org.specs2"        %% "specs2"             % "2.3.12"             % "test",
    "com.h2database"    % "h2"                  % "1.3.167",
    "org.clojure" % "core.match" % "0.3.0-alpha4",
    "com.cognitect" % "transit-clj" % "0.8.271"
  )
}
