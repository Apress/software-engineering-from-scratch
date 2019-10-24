// Listing 12-5
// val friends = Array("Jonathan", "Eric", "Jacob", "Kim", "Jeremy")

// def search(input: String): Any =  {
//     friends.foreach(friend => {
//         if(friend == input) {
//             return friend
//         }
//     })
// }

// val result = search("Jeremy")
// println(result)

// Listing 12-6
// def hash(item: String, group: Array[String]): Int = {
//     return item.length % group.length
// }

// val hashIndex = hash("Jeremy", friends)
// println(hashIndex)


// Listing 12-7

// val friends: Array[String] = new Array(5)

// def add(input:String, group: Array[String]) {
//     group(hash(input, group)) = input
// }

// add("Jonathan", friends)
// add("Eric", friends)
// add("Jacob", friends)
// add("Kim", friends)
// add("Jeremy", friends)

// def contains(input: String, group : Array[String]): Boolean = {
//     if(group(hash(input, group)) == input){
//         return true
//     }

//     return false
// }

// println(contains("Jeremy", friends))
// println(contains("Bob", friends))

// Listing 12-8

// import scala.collection.mutable.HashSet

// val friends: HashSet[String] = new HashSet()

// friends.add("Jonathan")
// friends.add("Eric")
// friends.add("Jacob")
// friends.add("Kim")
// friends.add("Jeremy")
// friends.add("Bob")
// friends.add("Eric")

// println(friends)
// println(friends.contains("Jeremy"))
// println(friends.contains("Bob"))

// Listing 12-9

// import scala.collection.mutable.TreeSet

// val numbers: TreeSet[Int] = new TreeSet()

// numbers.add(1)
// numbers.add(3)
// numbers.add(13)
// numbers.add(7)
// numbers.add(5)
// numbers.add(10)
// numbers.add(14)
// numbers.add(15)
// numbers.add(11)
// numbers.add(10)

// println(numbers)
// println(numbers.contains(5))

// Listing 12-10

import scala.collection.mutable.HashMap

val friends: HashMap[String, Int] = new HashMap()

friends.put("Jonathan", 32)
friends.put("Eric", 27)
friends.put("Jacob", 21)
friends.put("Kim", 42)
friends.put("Jeremy", 18)

println(friends)
println(friends.contains("Jeremy"))

import scala.collection.mutable.TreeMap

val ages: TreeMap[Int, String] = new TreeMap()

ages.put(32, "Jonathan")
ages.put(27, "Eric")
ages.put(21, "Jacob")
ages.put(42, "Kim")
ages.put(18, "Jeremy")

println(ages)
println(ages.contains(18))
