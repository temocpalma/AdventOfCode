package com.advent

class Main {

  static void main (String[] args) {
    println "*"*50+" Day 1"
    processDay1()
    println "*"*50+" Day 3"
    processDay3()
  }

  static void processDay1() {
    String pathInstructions = "src/main/groovy/resources/instructions-d1.txt"
    File instr = new File(pathInstructions)
    String fileInstructions = instr.text
    println "fileInstructions: ${fileInstructions}"
    Day1Service day1Service = new Day1Service()
    Long floor = day1Service.executeInstructions(fileInstructions)
    println "Current Floor: ${floor}"
  }

  static void processDay3() {
    String pathInstructions = "src/main/groovy/resources/instructions-d3.txt"
    File instr = new File(pathInstructions)
    String fileInstructions = instr.text
    //println "fileInstructions: ${fileInstructions}"
    Day3Service day3Service = new Day3Service()
    day3Service.processInstruction(fileInstructions)
    day3Service = new Day3Service()
    day3Service.processInstructionsWithRoboSanta(fileInstructions)
  }

}
