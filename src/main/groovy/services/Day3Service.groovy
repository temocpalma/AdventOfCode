package com.advent

class Day3Service {
  House currentHouse = new House(x:0,y:0)
  List houses = [currentHouse]
  String prevInstruction = ""
  House locationSanta = currentHouse
  House locationRoboSanta = currentHouse
  Integer turn = 1//1 is Santa turn, 0 is Robo-santa turn

  void processInstruction(String instructions){
    instructions.each { current ->
      House newCurrentHouse = getNewCurrentHouseForInstruction(current.trim())
      if (instructionIsNotOppositeToPrevious(current) && newHouseIsNotYetVisited(newCurrentHouse)) {
        houses << newCurrentHouse
      }
      prevInstruction = current
      locationSanta = newCurrentHouse
    }
    println "Visited houses: ${houses.size()}"
  }

  void processInstructionsWithRoboSanta(String instructions) {
    instructions.each { current ->
      House newCurrentHouse = getNewCurrentHouseForInstruction(current.trim())
      if (newHouseIsNotYetVisited(newCurrentHouse)) {
        houses << newCurrentHouse
      }
      relocate(newCurrentHouse)
    }
    println "Visited houses with Robo-Santa: ${houses.size()}"
  }

  void relocate(House newLocation) {
    if (turn) {
      locationSanta = newLocation
      turn = 0
    } else {
      locationRoboSanta = newLocation
      turn = 1
    }
  }

  House getNewCurrentHouseForInstruction(String currentInstruction) {
    setCurrentHouseOfTurn()
    int xNew = getNewXLocation(currentInstruction)
    int yNew = getNewYLocation(currentInstruction)
    new House(x:xNew, y:yNew)
  }

  Boolean instructionIsNotOppositeToPrevious(String instruction) {
    String bothInstructions = prevInstruction+instruction
    !(bothInstructions == "<>" || bothInstructions == "><" || bothInstructions == "v^" || bothInstructions == "^v")
  }

  void setCurrentHouseOfTurn() {
    if (turn) {
      currentHouse = locationSanta
    } else {
      currentHouse = locationRoboSanta
    }
  }

  int getNewXLocation(currentInstruction) {
    if (currentInstruction == "<") {
      return currentHouse.x-1
    } else if (currentInstruction == ">") {
      return currentHouse.x+1
    } else {
      return currentHouse.x
    }
  }

  int getNewYLocation(currentInstruction) {
    if (currentInstruction == "^") {
      return currentHouse.y-1
    } else if (currentInstruction == "v") {
      return currentHouse.y+1
    } else {
      return currentHouse.y
    }
  }

  Boolean newHouseIsNotYetVisited(House newHouse) {
    def exists = houses.collect {
          if (it.x==newHouse.x && it.y==newHouse.y)
                    it
    }.findResults{it}.unique()

    if (exists)
      false
    else
      true
  }

}
