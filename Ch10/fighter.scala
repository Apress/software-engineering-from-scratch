package CombatGame
class Fighter (var weapon: Weapon, var hp: Int = 20) {
    def reduceHP(damage: Int) {
        this.hp -= damage
    }

    def attack(opponent: Fighter){
        weapon.attack(opponent)
    }
}