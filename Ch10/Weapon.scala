package CombatGame
trait Weapon {
    val range: Int;
    val attackDamage: Int;
    def attack(opponent: Fighter)
}