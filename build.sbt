
name := "myApp"
version := VERSIONS.app
scalaVersion := VERSIONS.scala


libraryDependencies ++= Seq(
        "com.lihaoyi" % "ammonite" % VERSIONS.ammonite % "test" cross CrossVersion.full,
        "org.scalatest" %% "scalatest" % VERSIONS.scalatest % Test
        )

sourceGenerators in Test += Def.task {
    val file = (sourceManaged in Test).value / "amm.scala"
        IO.write(file, """object amm extends App { 
					ammonite.Main.main(args) 
					}""")
        Seq(file)
}.taskValue

trapExit := false
