import math._
import scala.collection.mutable.ListBuffer

object examples extends App {
    // println("Hello World!")
    println(pow(3,2))
    println(round(2.45))
    
    var splitList = "apples, oranges, bananas".split(",")
    var fruit = new ListBuffer[String]
    for(i <- Range(0,splitList.length)){
        fruit += splitList(i)
    }
    println(fruit)
}