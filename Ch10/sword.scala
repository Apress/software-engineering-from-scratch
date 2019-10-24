package CombatGame
class Sword (val length: Int = 10, val attackDamage: Int = 5) {
    def attack(opponent: Fighter){
        opponent.reduceHP(attackDamage)
    }
}