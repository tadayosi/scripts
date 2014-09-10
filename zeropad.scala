#!/usr/bin/env scala

import java.io._

if (args.length < 3 || args(0).contains("help")) {
  println("""usage:
  > zeropad.scala <target dir> <file extension> <filename length>""")
  sys.exit
}

new File(args(0)).listFiles
  .filter(_.getName.endsWith(args(1)))
  .foreach { file =>
  val newName = file.getName.reverse.padTo(args(2).toInt + args(1).length, '0').reverse
  println(file.getName + " -> " + newName)
  file.renameTo(new File(file.getParent, newName))
}
