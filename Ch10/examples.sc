//non-structured
def isMMA(fightingType: String): Boolean = {
	if(fightingType == "boxing"){
		return false
	}
    if(fightingType == "Tai Chi"){
        return false
    }
    if(fightingType == "Jeet Kune Do"){
        return true
    }
    return false
}

//structured
def isMMA(fightingType: String): Boolean = {
	if(fightingType == "boxing"){
		false
	}
    else if(fightingType == "Tai Chi"){
        false
    }
    else if(fightingType == "Jeet Kune Do"){
        true
    }
    else {
        false
    }
}

println(isMMA("Jeet Kune Do"))