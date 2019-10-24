package CombatGame
object run extends App {
    val Thief = new Fighter(new Dagger())    
    val Knight = new Fighter(new BroadSword())
    
    Thief.attack(Knight)
    Knight.attack(Thief)
    println(Thief.hp, Knight.hp)
}