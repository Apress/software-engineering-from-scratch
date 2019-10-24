import java.io.File
import java.io.PrintWriter
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack
import scala.collection.mutable.Queue
import scala.collection.mutable.Map
import scala.math.min


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

        def write(curdir: String, userInput: String){
            var tokens = userInput.split(" ")
            println("[Enter the text you wish to write to your new file below]")
            var textBody = readLine()
            try{
                new PrintWriter(s"${curdir}/${tokens(1).trim}.txt") { write(textBody); close }
                println("[Saving File...]")
            }
            catch {
                case _: Throwable =>  println("An error occured trying to write a text file.")
            }
        }

        def list(curdir: String, sort: Option[String]){
            val dir = new File(curdir).listFiles.map(file => stripDir(file.toString))
            sort match {
                case Some(_) => {
                    val sortedDir = mergeSort(ArrayBuffer(dir: _*))
                    sortedDir.foreach(println)
                }
                case None => dir.foreach(println)
            }
        }

        def mkdir(curdir: String, dirname: String){
            println(s"[Creating Directory ${dirname}... ]")
            new File(s"${curdir}/${dirname}").mkdir()
        }

        def dirExists(curdir: String, newdir: String): Boolean = {
            var dir = new File(curdir).listFiles
            dir.foreach(item => if(stripDir(item.toString) == newdir) return true)

            return false
        }

        def stripDir(fileString: String): String = {
            val filename = fileString.split("/")
            return filename(filename.length - 1)
        }

        def changeDir(curdir: String, newdir: String): String = {
            if(newdir == ".." && curdir != "./root") { return curdir.split("/").init.mkString("/") }
            if(dirExists(curdir, newdir)) { return s"${curdir}/${newdir}" }
            else { println(s"[Directory ${newdir} not found... ]"); return curdir}
        }

        def mergeSort(files: ArrayBuffer[String]): ArrayBuffer[String] = {
            val midpoint = files.length / 2
            midpoint match {
                case 0 => files
                case _ => 
                    val (left, right) = files.splitAt(midpoint)
                    merge(mergeSort(left), mergeSort(right))
            }
        }

        def merge(left: ArrayBuffer[String], right: ArrayBuffer[String]): ArrayBuffer[String] = {
            (left, right) match {
                case (_, r) if r.isEmpty => left
                case (l, _) if l.isEmpty => right
                case (_, _) => 
                    if (left.head > right.head) ArrayBuffer(left.head) ++ merge(left.tail, right)
                    else ArrayBuffer(right.head) ++ merge(left, right.tail)
            }
        }

        def search(curdir: String, keyword: String, fileList: Option[ArrayBuffer[String]] = None): String = {
            val files = fileList match {
                case Some(f) => f
                case None => mergeSort(ArrayBuffer(new File(curdir).listFiles.map(file => stripDir(file.toString)): _*))
            }
            val midpoint = files.length / 2
            return files.length match {
                case 1 => if(editDist(keyword, files(0)) < 2) files(0) else "No match found."
                case 2 => if(editDist(keyword, files(0)) < 2) files(0) else if (editDist(keyword, files(1)) < 2) files(1) else "No match found."
                case _ => 
                    val (left, right) = files.splitAt(midpoint)
                    if(editDist(keyword, files(midpoint)) < 2) files(midpoint) 
                    else if (keyword > files(midpoint)) search(curdir, keyword, Some(left))
                    else search(curdir, keyword, Some(right))
            }
        }

        def extractFolders(dir: String): Array[String] = {
            var directory = new File(dir).listFiles
            directory.filter(item => item.isDirectory()).map(d => d.toString)
        }

        def breadthFirstSearch(keyword: String) {
            val foldersToSearch: Queue[String] = Queue("./root")
            var folderFound = ""
            var searchResult = ""

            while (!foldersToSearch.isEmpty && folderFound.length == 0) {
                val curSearchFolder = foldersToSearch.dequeue()
                searchResult = search(curSearchFolder, keyword)
                if(editDist(searchResult, keyword) < 2) {
                    folderFound = curSearchFolder
                }
                foldersToSearch ++= extractFolders(curSearchFolder)
            }
            if(folderFound.length > 0) println(s"Found ${searchResult} in ${folderFound}")
            else println("No match found using breadth first search.")
        }

        def depthFirstSearch(keyword: String) {
            val foldersToSearch: Stack[String] = Stack("./root")
            var folderFound = ""
            var searchResult = ""

            while (!foldersToSearch.isEmpty && folderFound.length == 0) {
                val curSearchFolder = foldersToSearch.pop()
                searchResult = search(curSearchFolder, keyword)
                if(editDist(searchResult, keyword) < 2) {
                    folderFound = curSearchFolder
                }
                foldersToSearch.pushAll(extractFolders(curSearchFolder))
            }
            if(folderFound.length > 0) println(s"Found ${searchResult} in ${folderFound}")
            else println("No match found using depth first search.")
        }

        def editDist(s1: String, s2: String): Int = {
            val memoizedCosts = Map[(Int, Int), Int]()

            def lev(s1_length: Int, s2_length: Int): Int = {
                memoizedCosts.getOrElseUpdate((s1_length, s2_length), 
                    (s1_length, s2_length) match {
                    case (s1L, 0) => s1L
                    case (0, s2L) => s2L
                    case (s1L, s2L) =>
                        List(
                            1 + lev(s1L - 1, s2L),
                            1 + lev(s1L, s2L - 1), 
                            (if (s1(s1L - 1) != s2(s2L - 1)) 1 else 0) + lev(s1L - 1, s2L - 1),
                        ).min
                    }
                )
            }

            lev(s1.length, s2.length)
            memoizedCosts(s1.length, s2.length)
        }

    }
}