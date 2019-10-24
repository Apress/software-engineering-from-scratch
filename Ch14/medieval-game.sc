object CharacterFactory {
    abstract class Character {
        val weapon: String
        val hitpoints: Int
        val reach: Int
    }

    private case class Barbarian(
        weapon: String = "Long Sword",
        hitpoints: Int = 50,
        reach: Int = 5
    ) extends Character

    private case class Magician(
        weapon: String = "Staff",
        hitpoints: Int = 30,
        reach: Int = 15
    ) extends Character

    private case class Archer(
        weapon: String = "Bow",
        hitpoints: Int = 25,
        reach: Int = 3
    ) extends Character

    def apply(character: String, bonus: String): Character =  {
        val selectedCharacter = character match {
            case "Barbarian" => new Barbarian
            case "Magician" => new Magician
            case "Archer" => new Archer
            case _ => throw new Exception("Invalid Selection")
        }

        return bonus match {
            case "Extra Health" => new ExtraHealth(selectedCharacter)
            case "Extra Range" => new ExtraRange(selectedCharacter)
            case _ => selectedCharacter
        }
    }

    private case class ExtraHealth(character: Character) extends Character {
        override val weapon = character.weapon
        override val hitpoints = character.hitpoints + 10
        override val reach = character.reach

        override def toString(): String = {
            return s"${character.getClass.getSimpleName}(${weapon},${hitpoints},${reach})"
        }
    }

    private case class ExtraRange(character: Character) extends Character {
        override val weapon = character.weapon
        override val hitpoints = character.hitpoints
        override val reach = character.reach + 10

        override def toString(): String = {
            return s"${character.getClass.getSimpleName}(${weapon},${hitpoints},${reach})"
        }
    }
}

object main extends App {
    val choice = readLine("Choose your character: ")
    val bonus = readLine("Choose bonus: ")
    println(CharacterFactory(choice, bonus))
}

