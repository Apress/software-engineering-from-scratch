package CombatGame
abstract class Blade (override val range: Int = 2, override val attackDamage: Int = 5) 
extends Weapon
{
    def attack(opponent: Fighter){
        opponent.reduceHP(attackDamage)
    }
}