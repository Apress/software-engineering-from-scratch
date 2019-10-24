// Listin 7-10
def addCommand(userInput: String) {
    var tokens = userInput.split(" ")
    var plusIndex = tokens.indexOf("+")
    try {
        println(tokens(plusIndex-1).toDouble + tokens(plusIndex+1).toDouble)
    }
    catch {
        case _: Throwable => println("An error occured trying to process an addition command.")
    }
}

println("Welcome to the Nebula Operating System (NOS)! Version 1.0.3")
var command = ""
do {
    command = readLine("NOS> ")
    command match {
        case c if c.contains("+") => addCommand(c)
        case c if c.contains("-") => println(s"Subtraction command: ${command}")
        case c if c.equalsIgnoreCase("help") => println("Help Command")
        case c if c.equalsIgnoreCase("shutdown") => println("Shutting down...")
        case _ => println(s"${command} is not a known command.")
    }
}
while (!command.equalsIgnoreCase("shutdown"))