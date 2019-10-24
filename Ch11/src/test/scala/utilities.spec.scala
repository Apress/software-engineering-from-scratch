import org.scalatest._
package os.nebula {

    class UtilitiesSpec extends FunSpec {
        describe("When calling the add command") {
            describe("and passing 2 + 2") {
                it("should equal 4") {
                    assertResult(4){ Utilities.addCommand("2 + 2") }
                }
            }
        }
    }
}