package os.nebula {
    
    object nebula extends App {
        println("Welcome to the Nebula Operating System (NOS)! Version 1.1.1")
        var curdir = "./root"
        var command = ""
        do {
            val path = curdir.split("/").drop(2).mkString("/")
            command = readLine(if(path.length > 0) s"NOS/${path}> " else "NOS> ")
            command match {
                case c if c.contains("write") => Utilities.write(curdir, c)
                case c if c.contains("list") => Utilities.list(curdir, c.split(" ").lift(1))
                case c if c.contains("mkdir") => Utilities.mkdir(curdir, c.split(" ")(1))
                case c if c.contains("cd") => curdir = Utilities.changeDir(curdir, c.split(" ")(1))
                case c if c.contains("search -dfs") => Utilities.depthFirstSearch(c.split(" ")(2))
                case c if c.contains("search -bfs") => Utilities.breadthFirstSearch(c.split(" ")(2))
                case c if c.contains("search") => println(Utilities.search(curdir, c.split(" ")(1)))
                case c if c.contains("+") => println(Utilities.addCommand(c))
                case c if c.equalsIgnoreCase("help") => println("Help Command")
                case c if c.equalsIgnoreCase("shutdown") => println("Shutting down...")
                case _ => println(s"${command} is not a known command.")
            }
        }
        while (!command.equalsIgnoreCase("shutdown"))
    }
}

