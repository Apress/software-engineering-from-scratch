package CombatGame
class Knife(override val length: Int = 3, override val attackDamage: Int = 2, val healPower: Int = 5) 
    extends Sword(length, attackDamage) {
        def heal(ally: Fighter) {
            ally.hp += healPower
        }
    }
