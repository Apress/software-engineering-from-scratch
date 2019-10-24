import java.io.PrintWriter
package os.nebula {
    object Utilities {
        def addCommand(userInput: String): Any = {
            var tokens = userInput.split(" ")
            var plusIndex = tokens.indexOf("+")
            try {
                 return tokens(plusIndex-1).toDouble + tokens(plusIndex+1).toDouble
            }
            catch {
                case _: Throwable => println("An error occured trying to process an addition command.")
            }
        }

        var files = new scala.collection.mutable.ListBuffer[TextFile]()

        def createTextFile(userInput: String) {
            var tokens = userInput.split("/")
            try{
                files += new TextFile(tokens(1).trim, tokens(2).trim)
            }
            catch {
                case _: Throwable =>  println("An error occured trying to create a text file.")
            }
        }

        def showTextFiles(){
            for(i <- Range(0,files.length)){
                println(files(i))
            }
        }

        def write(userInput: String){
            var tokens = userInput.split(" ")
            println("[Enter the text you wish to write to your new file below]")
            var textBody = readLine()
            try{
                new PrintWriter(s"${tokens(1).trim}.txt") { write(textBody); close }
                println("[Saving File...]")
            }
            catch {
                case _: Throwable =>  println("An error occured trying to write a text file.")
            }
        }

        def list(){
            import java.io.File
            var dir = new File("./").listFiles
            for(file <- Range(0,dir.length)){
                if(dir(file).getName.contains("txt")){
                    println(dir(file))
                }
            }
        }
    }
}