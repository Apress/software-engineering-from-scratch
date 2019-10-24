// Listing 7-1
// def blackhat(inputObject: String): Any = {
//     if(inputObject.equalsIgnoreCase("handkerchief")) {
//         return "Dove"
//     }
// }

// println(blackhat("handkerchieF"))

// Listing 7-2
// def magician(name: String): String = {
//     if(name.equalsIgnoreCase("David")){
//         return "David Copperfield"
//     }
//     return "Harry Houdini"
// }

// println(magician("david"))
// println(magician(""))

// Listing 7-3
// def generateDove() = {
//     "Dove"
// }

// def generateBirds(numOfBirds: Int, typeOfBird: String = "Dove") = {
//     s"${typeOfBird} " * numOfBirds
// }

// println(generateDove())
// println(generateBirds(3, "Swan"))

// Listing 7-4
// def presto(): Unit = {
//     println("Poof!")
// }

// presto()

// Listing 7-5
// def generateDove() = {
//     "Dove"
// }

// def generateBirds(numOfBirds: Int, typeOfBird: String = "Dove") = {
//     s"${typeOfBird} " * numOfBirds
// }

// var birds1 = generateBirds(1)
// var birds2 = generateBirds(1 + 1, "Finch")
// var three = 3
// var birds3 = generateBirds(three, generateDove())
// var birdList = List(birds1, birds2, birds3)

// for(bird <- birdList) println(bird)

// Listing 7-6
// def generateDove() = {
//     "Dove"
// }

// def generateBirds(numOfBirds: Int, typeOfBird: String = "Dove") = {
//     s"${typeOfBird} " * numOfBirds
// }

// var birdList = List(generateBirds(1), generateBirds(1 + 1, "Finch"), generateBirds(three, generateDove()))
// for(bird <- birdList) println(bird)

// Listing 7-7
// var cipher = new StringBuilder("Ue:h5jf6& Wit Set d6'r!cfjet6,!vli3dn9lp!cs5uetdt9ds5jf 7swa!een66pcb Eepcen5ffdd.ds!ctT6gi,9eda!dwte5s3!i:kd4kkdd!aey55pcbue9!vbu%vtatew4!aei6.uce Fag5koeas69 Waj5isbd!cbe7nw.te!asd4ywau66hdajd4nwahce.b5")

// var shiftedEncoding = List.newBuilder[Int]
// for(i <- Range(0, cipher.length)){
//     if(i % 2 == 0){
//         shiftedEncoding += i
//     }
// }
// var positionalEncoding = List.newBuilder[Int]
// for(i <- Range(0, cipher.length)){
//     if(i % 3 == 0){
//         positionalEncoding += i
//     }
// }
// for(i <- Range(0,cipher.length)){
//     if(shiftedEncoding.result().contains(i)){
//         cipher(i) = (cipher(i)-1).asInstanceOf[Char]
//     }
// }
// var message = ""
// for(i <- Range(0,cipher.length)){
//     if(positionalEncoding.result().contains(i)){
//         message += cipher(i)
//     }
// }
// println(message)

// Listing 7-8
// var cipher = new StringBuilder("Ue:h5jf6& Wit Set d6'r!cfjet6,!vli3dn9lp!cs5uetdt9ds5jf 7swa!een66pcb Eepcen5ffdd.ds!ctT6gi,9eda!dwte5s3!i:kd4kkdd!aey55pcbue9!vbu%vtatew4!aei6.uce Fag5koeas69 Waj5isbd!cbe7nw.te!asd4ywau66hdajd4nwahce.b5")

// def findPositions(mod: Int): List[Int] = {
//     var listBuilder = List.newBuilder[Int]
//     for(i <- Range(0, cipher.length)){
//         if(i % mod == 0){
//             listBuilder += i
//         }
//     }
//     return listBuilder.result()
// }

// var shiftedEncoding = findPositions(2)
// var positionalEncoding = findPositions(3)
// for(i <- Range(0,cipher.length)){
//     if(shiftedEncoding.contains(i)){
//         cipher(i) = (cipher(i)-1).asInstanceOf[Char]
//     }
// }
// var message = ""
// for(i <- Range(0,cipher.length)){
//     if(positionalEncoding.contains(i)){
//         message += cipher(i)
//     }
// }
// println(message)

// Listing 7-9
var cipher = new StringBuilder("Ue:h5jf6& Wit Set d6'r!cfjet6,!vli3dn9lp!cs5uetdt9ds5jf 7swa!een66pcb Eepcen5ffdd.ds!ctT6gi,9eda!dwte5s3!i:kd4kkdd!aey55pcbue9!vbu%vtatew4!aei6.uce Fag5koeas69 Waj5isbd!cbe7nw.te!asd4ywau66hdajd4nwahce.b5")

def findPositions(mod: Int, encryptedMessage: StringBuilder): List[Int] = {
    var listBuilder = List.newBuilder[Int]
    for(i <- Range(0, encryptedMessage.length)){
        if(i % mod == 0){
            listBuilder += i
        }
    }
    return listBuilder.result()
}

var shiftedEncoding = findPositions(2, cipher)
var positionalEncoding = findPositions(3, cipher)
for(i <- Range(0,cipher.length)){
    if(shiftedEncoding.contains(i)){
        cipher(i) = (cipher(i)-1).asInstanceOf[Char]
    }
}
var message = ""
for(i <- Range(0,cipher.length)){
    if(positionalEncoding.contains(i)){
        message += cipher(i)
    }
}
println(message)