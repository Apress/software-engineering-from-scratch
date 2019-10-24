package data.structures

object main extends App {
    val users: LinkedList[String] = new LinkedList("me")
    println(users)
    users.add("you")
    println(users)
}