package os.nebula {
    
    object nebula extends App {
        println("Welcome to the Nebula Operating System (NOS)! Version 1.0.5")
        var command = ""
        do {
            command = readLine("NOS> ")
            command match {
                case c if c.contains("write") => Utilities.write(c)
                case c if c.contains("list") => Utilities.list()
                case c if c.contains("make") => Utilities.createTextFile(c)
                case c if c.contains("show") => Utilities.showTextFiles()
                case c if c.contains("+") => Utilities.addCommand(c)
                case c if c.contains("-") => println(s"Subtraction command: ${command}")
                case c if c.equalsIgnoreCase("help") => println("Help Command")
                case c if c.equalsIgnoreCase("shutdown") => println("Shutting down...")
                case _ => println(s"${command} is not a known command.")
            }
        }
        while (!command.equalsIgnoreCase("shutdown"))
    }
}

