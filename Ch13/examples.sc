// Listing 13-1
// def fibonacci(n: Int): Int = {
//     if(n <= 1) n else (fibonacci(n-1) + fibonacci(n-2))
// }

// println(fibonacci(5))
// import scala.math.min

// def levenshtein(s1: String, s2: String): scala.collection.mutable.Map[(Int, Int), Int] = {
//     val memoizedCosts = scala.collection.mutable.Map[(Int, Int), Int]()

//     def lev(s1_index: Int, s2_index: Int): Int = {
//         memoizedCosts.getOrElseUpdate((s1_index, s2_index), (s1_index, s2_index) match {
//         case (s1i, 0) => s1i
//         case (0, s2i) => s2i
//         case (s1i, s2i) =>
//             Seq(
//                 1 + lev(s1i - 1, s2i),
//                 1 + lev(s1i, s2i - 1),
//                 lev(s1i - 1, s2i - 1) + (if (s1(s1i - 1) != s2(s2i - 1)) 1 else 0
//             )).min
//         })
//     }

//     lev(s1.length, s2.length)
//     memoizedCosts
// }

import scala.math.min
import scala.collection.mutable.Map

def editDist(s1: String, s2: String): Int = {
    val memoizedCosts = Map[(Int, Int), Int]()

    def lev(s1_index: Int, s2_index: Int): Int = {
        memoizedCosts.getOrElseUpdate((s1_index, s2_index), 
            (s1_index, s2_index) match {
            case (s1i, 0) => s1i
            case (0, s2i) => s2i
            case (s1i, s2i) =>
                List(
                    1 + lev(s1i - 1, s2i),
                    1 + lev(s1i, s2i - 1), 
                    (if (s1(s1i - 1) != s2(s2i - 1)) 1 else 0) + lev(s1i - 1, s2i - 1),
                ).min
            }
        )
    }

    lev(s1.length, s2.length)
    memoizedCosts(s1.length, s2.length)
}

println(editDist("before", "between"))