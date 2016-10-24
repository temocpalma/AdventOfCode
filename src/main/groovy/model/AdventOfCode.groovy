package com.advent

class AdventOfCode {
  House currentHouse = new House(x:0,y:0)
  List houses = [currentHouse]
  String prevInstruction = ""

  void processInstruction(String instructions){
    instructions.each { current ->
      House newCurrentHouse = getNewCurrentHouseForInstruction(current)
      if (instructionIsNotOppositeToPrevious(current) && newHouseIsNotYetVisited(newCurrentHouse)) {
        houses << newCurrentHouse
      }
      prevInstruction = current
      currentHouse = newCurrentHouse
    }
    println "Visited houses: ${houses.size()}"
  }

  House getNewCurrentHouseForInstruction(String currentInstruction) {
    int xNew = getNewXLocation(currentInstruction)
    int yNew = getNewYLocation(currentInstruction)
    new House(x:xNew, y:yNew)
  }

  Boolean instructionIsNotOppositeToPrevious(String instruction) {
    String bothInstructions = prevInstruction+instruction
    !(bothInstructions == "<>" || bothInstructions == "><" || bothInstructions == "v^" || bothInstructions == "^v")
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
