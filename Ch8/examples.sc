// Listing 8-1
// class Weapon(weaponType: String = "Musket") {
//     println(s"Construction of ${this.weaponType} completed.")
// }

// var musket = new Weapon()
// for(i <- Range(1,10001)){
//     new Weapon(s"Musket #${i}")
// }

// Listing 8-2
// class Weapon(weaponType: String = "Musket") {
//     println(s"Construction of ${this.weaponType} completed.")
// }

// var musket = new Weapon()
// println(musket.weaponType)

// Listing 8-3
// class Weapon(var weaponType: String = "Musket", barrelLength: Int) {
//     private var length = s"${barrelLength} inches"

//     def getBarrelLength(): String = {
//         return s"The barrell is ${this.length} long"
//     }
//     def setBarrelLength(length: Int){
//         this.length = s"${length} inches"
//     }
// }

// var musket = new Weapon("Musket", 36)
// println(musket.weaponType)
// println(musket.getBarrelLength)
// musket.weaponType = "Big Musket"
// musket.setBarrelLength(40)
// println(musket.weaponType)
// println(musket.getBarrelLength)

// Listing 8-4
// class Weapon(var weaponType: String = "Musket", barrelLength: Int) {
//     private var length = s"${barrelLength} inches"

//     def getBarrelLength(): String = {
//         return s"The barrell is ${this.length} long"
//     }
//     def setBarrelLength(length: Int){
//         this.length = s"${length} inches"
//     }
// }

// var johnsMusket = new Weapon("Musket", 36)
// var janesMusket = johnsMusket
// var jimsMusket = new Weapon("Heavy Musket", 42)

// janesMusket.setBarrelLength(40)
// jimsMusket.setBarrelLength(45)
// println(johnsMusket.getBarrelLength)
// println(jimsMusket.getBarrelLength)

// janesMusket = jimsMusket
// janesMusket.weaponType = "Jim and Jane's Musket"
// println(jimsMusket.weaponType)
// println(johnsMusket.weaponType)

// // Listing 8-5
// class Weapon(var weaponType: String = "Musket", barrelLength: Int) {
//     private var length = s"${barrelLength} inches"

//     def getBarrelLength(): String = {
//         return s"The barrell is ${this.length} long"
//     }
//     def setBarrelLength(length: Int){
//         this.length = s"${length} inches"
//     }

//     override def equals(comparableObject: Any): Boolean = {
//         return (comparableObject.asInstanceOf[Weapon].weaponType == this.weaponType && comparableObject.asInstanceOf[Weapon].getBarrelLength == this.getBarrelLength)
//     }
// }

// var weapon1: Weapon = new Weapon("Rifle",50)
// var weapon2 = new Weapon("Rifle",50)
// println(weapon1 == weapon2)

// Listing 8-6
// class Weapon(var weaponType: String = "Musket", barrelLength: Int) {
//     private var length = s"${barrelLength} inches"

//     def getBarrelLength(): String = {
//         return s"The barrell is ${this.length} long"
//     }
//     def setBarrelLength(length: Int){
//         this.length = s"${length} inches"
//     }

//     override def equals(comparableObject: Any): Boolean = {
//         return (comparableObject.asInstanceOf[Weapon].weaponType == this.weaponType && comparableObject.asInstanceOf[Weapon].getBarrelLength == this.getBarrelLength)
//     }
// }

// var weapon1: Weapon = new Weapon("Rifle",50)
// println(weapon1)

// Listing 8-7
// class Weapon(var weaponType: String = "Musket", barrelLength: Int) {
//     private var length = s"${barrelLength} inches"

//     def getBarrelLength(): String = {
//         return s"The barrell is ${this.length} long"
//     }
//     def setBarrelLength(length: Int){
//         this.length = s"${length} inches"
//     }

//     override def equals(comparableObject: Any): Boolean = {
//         return (comparableObject.asInstanceOf[Weapon].weaponType == this.weaponType && comparableObject.asInstanceOf[Weapon].getBarrelLength == this.getBarrelLength)
//     }

//     override def toString(): String = {
//         return s"Weapon(type: ${this.weaponType}, length: ${this.length})"
//     }
// }

// var weapon1: Weapon = new Weapon("Rifle",50)
// println(weapon1)

// Listing 8-8
// case class Weapon(weaponType: String = "Musket", length: Int)

// var weapon1 = new Weapon("Rifle",50)
// var weapon2 = new Weapon("Rifle",50)
// var weapon3 = new Weapon("Musket",32)
// println(weapon1)
// println(weapon1 == weapon2)
// println(weapon2 == weapon3)
// println(weapon2.weaponType)
// println(weapon3.length)

// Listing 8-9
case class Weapon(weaponType: String = Weapon.default_weapon, length: Int)

object Weapon {
    val unit_of_measurement = "inches"
    val default_weapon = "Musket"
    def useWeapon(weapon: Weapon){
        println(s"Using weapon ${weapon}")
    }
}

println(Weapon.unit_of_measurement)
println(Weapon.default_weapon)
Weapon.useWeapon(new Weapon("Big" + Weapon.default_weapon, 40))