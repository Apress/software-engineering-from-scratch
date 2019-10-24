package data.structures

case class Node[T](data: T, var next: Node[T] = null)