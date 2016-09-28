package com.advent

class AdventOfCode {
  int visited = 1
  List houses = [new House(x:0,y:0)]
  String prevInstruction = ""

  void processInstruction(String instruction){
    instruction.each { current ->
      if (instructionIsNotOppositeToPrevious(current)) {
        visited++
      }
      prevInstruction = current
    }
  }

  Boolean instructionIsNotOppositeToPrevious(String instruction) {
    String bothInstructions = prevInstruction+instruction
    !(bothInstructions == "<>" || bothInstructions == "><" || bothInstructions == "v^" || bothInstructions == "^v")
  }
}
