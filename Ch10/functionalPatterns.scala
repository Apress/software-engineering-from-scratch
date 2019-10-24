package CombatGame
object funcs extends App {
    // Listing 10-9
    // def attack(opponent: Fighter, damage: Int): Fighter = {
    //     return new Fighter(opponent.weapon, opponent.hp - damage)
    // }

    // // Listing 10-10
    // def repeat(n: Int, iter: Int = 0)(func: => Unit){
    //     if(iter < n) {
    //         func
    //         repeat(n, iter + 1)(func)
    //     }
    // }

    // val dagger = new Dagger()
    // repeat(3){ println(dagger.attackDamage) }

    // Listing 10-11
    // val data = List("Bruce Lee", "Chuck Norris", "Chuck Liddell", "Ronda Rousey")
    // def printFighter(fighter: String): Unit = {
    //     println(fighter)
    // }
    // data.foreach(printFighter)
    // data.foreach(println)
    // data.foreach((fighter) => {
    //     println(fighter)
    // })
    // data.foreach(fighter => println(fighter))

    // Listing 10-12
    // val data = List("Bruce Lee", "Chuck Norris", "Chuck Liddell", "Ronda Rousey")
    // val formattedData = data.map(fighter => fighter.toUpperCase)
    // println(formattedData)

    // Listing 10-13
    // val data = List(List("Bruce Lee", 141), List("Chuck Norris", 170),
    // List("Chuck Liddell", 205), List("Ronda Rousey", 134))
    // val flattenedData = data.flatMap(item => item)
    // println(flattenedData)

    // Listing 10-14
    // val data = List(List("Bruce Lee", 141), List("Chuck Norris", 170),
    // List("Chuck Liddell", 205), List("Ronda Rousey", 134))
    // val filteredData = data.filter(item => item(1).asInstanceOf[Int] > 140)
    // println(filteredData)

    // Listing 10-15
    // val data = List(List("Bruce Lee", 141), List("Chuck Norris", 170),
    // List("Chuck Liddell", 205), List("Ronda Rousey", 134))
    // val findData = data.find(item => item(0).toString.contains("Chuck"))
    // println(findData)

    // Listing 10-16
    // val data = List(List("Bruce Lee", 141), List("Chuck Norris", 170),
    // List("Chuck Liddell", 205), List("Ronda Rousey", 134))
    // val reducedData = data.map(item => item(1).asInstanceOf[Int]).reduce(_+_)
    // println(reducedData)

    // Listing 10-17
    // val data = List(List("Bruce Lee", 141), List("Chuck Norris", 170),
    // List("Chuck Liddell", 205), List("Ronda Rousey", 134))
    // val foldedData = data.map(item => item(1).asInstanceOf[Int]).fold(100)(_+_)
    // println(foldedData)

    // Listing 10-18
    // val namesData = List("Bruce Lee", "Chuck Norris", "Chuck Liddell", "Ronda Rousey")
    // val weightData = List(141, 170, 205, 134)
    // val zippedData = namesData.zip(weightData)
    // println(zippedData)

    // Listing 10-19 (return a string of the two chucks and their weights)
    val namesData = List("Bruce Lee", "Chuck Norris", "Chuck Liddell", "Ronda Rousey")
    val weightData = List(141, 170, 205, 134)
    val data = namesData
        .zip(weightData)
        .filter(item => item._1.contains("Chuck"))
        .map(item => List(item._1, item._2))
        .flatMap(item => item)
        .reduce((item1, item2) => s"${item1} ${item2}")
    println(data)
}