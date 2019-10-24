//Listing 6-4
// if(command.contains("+")) {
// 	println(s"Addition command: ${command}")
// }
// else {
// 	println("Cannot evaluate command.")
// }

// if(command.contains("-")) {
// 	println(s"Subtraction command: ${command}")
// }
// else {
// 	if(command.contains("help")) {
// 		println("Help command")
// 	}
// 	else {
// 		println("Cannot evaluate command.")
// 	}
// }

// if(false) println("A") else if(true) println("B")

//Listing 6-7
// println("Welcome to the Nebula Operating System (NOS)! Version 1.0.0")
// var command = readLine("NOS> ")
// println(command match {
//     case c if c.contains("+") => s"Addition command: ${command}"
//     case c if c.contains("-") => s"Subtraction command: ${command}"
//     case c if c.equalsIgnoreCase("help") => "Help Command"
//     case _ => s"${command} is not a known command." 
// })

//Listing 6-8
// println("Welcome to the Nebula Operating System (NOS)! Version 1.0.1")
// while (true) {
//     var command = readLine("NOS> ")
//     command match {
//         case c if c.contains("+") => println(s"Addition command: ${command}")
//         case c if c.contains("-") => println(s"Subtraction command: ${command}")
//         case c if c.equalsIgnoreCase("help") => println("Help Command")
//         case c if c.equalsIgnoreCase("shutdown") => scala.util.control.Breaks.break
//         case _ => println(s"${command} is not a known command.")
//     }
// }

// // Listing 6-10
// println("Welcome to the Nebula Operating System (NOS)! Version 1.0.2")
// var command = ""
// do {
//     command = readLine("NOS> ")
//     command match {
//         case c if c.contains("+") => println(s"Addition command: ${command}")
//         case c if c.contains("-") => println(s"Subtraction command: ${command}")
//         case c if c.equalsIgnoreCase("help") => println("Help Command")
//         case c if c.equalsIgnoreCase("shutdown") => println("Shutting down...")
//         case _ => println(s"${command} is not a known command.")
//     }
// }
// while (!command.equalsIgnoreCase("shutdown"))

// Listing 6-15
println("Welcome to the Nebula Operating System (NOS)! Version 1.0.2")
var command = ""
do {
    command = readLine("NOS> ")
    command match {
        case c if c.contains("+") => {
            var tokens = c.split(" ")
            var plusIndex = tokens.indexOf("+")
            try {
                println(tokens(plusIndex-1).toDouble + tokens(plusIndex+1).toDouble)
            }
            catch {
                case _: Throwable => println("An error occured trying to process an addition command.")
            }
        }
        case c if c.contains("-") => println(s"Subtraction command: ${command}")
        case c if c.equalsIgnoreCase("help") => println("Help Command")
        case c if c.equalsIgnoreCase("shutdown") => println("Shutting down...")
        case _ => println(s"${command} is not a known command.")
    }
}
while (!command.equalsIgnoreCase("shutdown"))