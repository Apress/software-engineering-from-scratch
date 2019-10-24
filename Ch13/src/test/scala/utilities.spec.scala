import org.scalatest._
import scala.collection.mutable.ArrayBuffer
package os.nebula {

    class UtilitiesSpec extends FunSpec {
        describe("When calling the add command") {
            describe("and passing 2 + 2") {
                it("should equal 4") {
                    assertResult(4){ Utilities.addCommand("2 + 2") }
                }
            }
        }

        describe("when sorting a list of files") {
            it("should return a sorted list") {
                assertResult(ArrayBuffer("1","2","3","4","5","6", "7").reverse){
                    Utilities.mergeSort(ArrayBuffer("5","6","3","7","1","4","2"))
                }
            }

            // it("should return a sorted list of files") {
            //     assertResult(ArrayBuffer("Alpha.txt", "Billy.txt","Jason.txt","Kimberly.txt","Tina.txt","Tommy.txt","Zack.txt","Zordon.txt").reverse){
            //         Utilities.mergeSort(ArrayBuffer("Zordon.txt", "Jason.txt", "Billy.txt", "Zack.txt", "Kimberly.txt", "Tina.txt", "Tommy.txt", "Alpha.txt"))
            //     }
            // }

            describe("if the list is empty or lenth 1") {
                it("should return the listt") {
                    assertResult(ArrayBuffer("1")){
                        Utilities.mergeSort(ArrayBuffer("1"))
                    }
                }
                it("should return the empty list") {
                    assertResult(ArrayBuffer()){
                        Utilities.mergeSort(ArrayBuffer())
                    }
                }
            }
        }

        describe("when searching a list of files") {
            it("should return the search term if it exists") {
                assertResult("abc.txt") {
                    Utilities.search("./root", "abc.txt", None)
                }
            }

            it("should return 'No match found.' if the search term is bad") {
                assertResult("No match found.") {
                    Utilities.search("./root", "Zordon.txt", None)
                }
            }
        }
    }
}