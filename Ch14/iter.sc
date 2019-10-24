val charactersList = List("Barbarian", "Magician", "Archer")
val charactersArray = Array("Barbarian", "Magician", "Archer")
val charactersSet = Set("Barbarian", "Magician", "Archer")
val charactersMap = Map(1 -> "Barbarian", 2 -> "Magician", 3 -> "Archer")

printAll(charactersList.iterator)
printAll(charactersArray.iterator)
printAll(charactersSet.iterator)
printAll(charactersMap.valuesIterator)

def printAll(group: Iterator[String]) {
    while (group.hasNext) {
        println(group.next())
    }
}

