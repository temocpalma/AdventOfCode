package com.advent

class Main {

  static void main (String[] args) {
    String pathInstructions = "src/main/groovy/resources/instructions.txt"
    File instr = new File(pathInstructions)
    String fileInstructions = instr.text
    println "fileInstructions: ${fileInstructions}"
    AdventOfCode advOfCode = new AdventOfCode()
    advOfCode.processInstruction(fileInstructions)
    advOfCode = new AdventOfCode()
    advOfCode.processInstructionsWithRoboSanta(fileInstructions)
  }

}
