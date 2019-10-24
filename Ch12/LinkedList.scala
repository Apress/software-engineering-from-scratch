package data.structures

case class LinkedList[T](private val data: T, var head: Node[T] = null) {
    head = new Node(data)
    
    def add(data: T) {
        val newNode = Node(data)
        if(this.head == null){
            this.head = newNode
        }
        else {
            var current = this.head
            while(current.next != null){
                current = current.next
            }
            current.next = newNode
        }
    }
}