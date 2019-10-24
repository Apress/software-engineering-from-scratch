// Listing 6-1
// print(2 + 2)
// println(“Same Line”)
// println(“New Line”)

// Listing 6-2
// println(readLine(“Enter a number: “).toInt * 3)

// Listing 6-5
// var choice = readLine("What flavor of ice cream do you like? ")

// if(choice.equalsIgnoreCase("chocolate")) {
// 	println("Rocky Road")
// }
// if(choice.equalsIgnoreCase("vanilla")) {
// 	println("French Vanilla")
// }
// if(choice.equalsIgnoreCase("fruity")) {
// 	println("Strawberry")
// }

// Listing 6-6
// println(choice.toLowerCase match{
//     case "chocolate" => "Rocky Road"
//     case "vanilla" => "French Vanilla"
//     case "fruity" => "Strawberry"
//     case _ => "Unknown Flavor"
// })

// Listing 6-11
// var i = 0
// while(i < 3) {
// 	println(s"This is iteration #${i}")
// 	i += 1
// }

// Listing 6-12
// for(i <- Range(0,3)) println(s"This is iteration #${i}")

// Listing 6-13
// var ints = Range(0,4)

// var shows = Map("Friends" -> List("Ross", "Rachel", "Joey"), "Big Bang Theory" -> List("Leonard", "Sheldon", "Penny"))

// for(i <- ints) println(s"This is iteration #${i}")
// for(i <- List("football", "basketball", "baseball")) println(s"I like ${i}.")
// for((show,characters) <- shows) {
// 	for(character <- characters) {
// 		println(s"${character} is in ${show}.")
// 	}
// }

// Listing 6-14
try { 
    throw new Exception() 
    } 
catch { 
    case _: IllegalArgumentException => println("Illegal argument provided.")
    case _: Throwable => println("An error occured.") 
}