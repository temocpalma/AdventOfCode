package com.advent

class Main {

  static void main (String[] args) {
    processDay3()
  }

  static void processDay3() {
    String pathInstructions = "src/main/groovy/resources/instructions.txt"
    File instr = new File(pathInstructions)
    String fileInstructions = instr.text
    println "fileInstructions: ${fileInstructions}"
    Day3Service day3Service = new Day3Service()
    day3Service.processInstruction(fileInstructions)
    day3Service = new Day3Service()
    day3Service.processInstructionsWithRoboSanta(fileInstructions)
  }

}
