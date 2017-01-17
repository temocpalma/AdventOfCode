package com.advent

import spock.lang.Specification
import spock.lang.Unroll

class Day3ServiceSpec extends Specification {

  Day3Service day3Service = new Day3Service()

  def "When instruction is > and previous is not opposite expect true"() {
    given:
      String instruction = ">"
    when:
      Boolean result = day3Service.instructionIsNotOppositeToPrevious(instruction)
    then:
      result == true
  }

  def "When instruction is > and previous is opposite expect false"() {
    given:
      String instruction = ">"
    and:
      day3Service.prevInstruction = "<"
    when:
      Boolean result = day3Service.instructionIsNotOppositeToPrevious(instruction)
    then:
      result == false
  }

  @Unroll
  def "When currentInstruction is #instr and currentHouse is (0,0) the new x house location should be #newX"() {
    given:
      String currentInstruction = instr
    and:
      day3Service = new Day3Service()
    when:
      int result = day3Service.getNewXLocation(currentInstruction)
    then:
      result == newX
    where:
    instr | newX
    ">"   | 1
    "<"   | -1
  }

  @Unroll
  def "When currentInstruction is #instr and currentHouse is (0,0) the new y house location should be #newY"() {
    given:
      String currentInstruction = instr
    and:
      day3Service = new Day3Service()
    when:
      int result = day3Service.getNewYLocation(currentInstruction)
    then:
      result == newY
    where:
    instr | newY
    "^"   | -1
    "v"   | 1
  }

  def "When new location do not exists in houses visted expect true"() {
    given:
      House house = new House(x:0, y:0)
    and:
      day3Service.houses = [new House(x:0, y:1)]
    when:
      def result = day3Service.newHouseIsNotYetVisited(house)
    then:
      result == true
  }

  def "When new location exists in houses visted expect false"() {
    given:
      House house = new House(x:0, y:0)
    and:
      day3Service.houses = [new House(x:0, y:0)]
    when:
      def result = day3Service.newHouseIsNotYetVisited(house)
    then:
      result == false

  }

  def "When instruction is > and previous instruction is not opposite should delivers presents to 2 houses"() {
    given:"The > instruction"
      String instruction = ">"
      Day3Service advCod = new Day3Service()
    when:
      advCod.processInstruction(instruction)
    then:
      advCod.houses.size == 2
  }

  def "When instruction is ^>v< should delivers presents to 4 houses"() {
    given:"The > instruction"
      String instruction = "^>v<"
    when:
      day3Service.processInstruction(instruction)
    then:
      day3Service.houses.size == 4
  }

  @Unroll
  def "When instruction is #instr should delivers presents to #visited houses"() {
    given:
      String instruction = instr
    when:
      day3Service.processInstruction(instruction)
    then:
      day3Service.houses.size == visited
    where:
      instr | visited
      ">"   | 2
      "^>v<"| 4
      "^v^v^v^v^v"  | 2
      ">^^v^"  | 4
      ">^^v^<>v<<<v<v^>>v^^^<"  | 15
  }

//With Robo-Santa

  def "Should visited 3 houses when instructions are ^v with Robo-Santa"() {
    given:"The instructions"
      String instructions = "^v"
    when: "Process the instructions with robo-santa"
      day3Service.processInstructionsWithRoboSanta(instructions)
    then: "We expect 3 houses visited"
      day3Service.houses.size() == 3
  }

  def "Should visited 3 houses when instructions are ^>v< with Robo-Santa"() {
    given:"The instructions"
      String instructions = "^>v<"
    when: "Process the instructions with robo-santa"
      day3Service.processInstructionsWithRoboSanta(instructions)
    then: "We expect 3 houses visited"
      day3Service.houses.size() == 3
  }

  def "Should visited 11 houses when instructions are ^v^v^v^v^v with Robo-Santa"() {
    given:"The instructions"
      String instructions = "^v^v^v^v^v"
    when: "Process the instructions with robo-santa"
      day3Service.processInstructionsWithRoboSanta(instructions)
    then: "We expect 11 houses visited"
      day3Service.houses.size() == 11
  }

  def "Should visited 17 houses when instructions are >^^v^<>v<<<v<v^>>v with Robo-Santa"() {
    given:"The instructions"
      String instructions = ">^^v^<>v<<<v<v^>>v"
    when: "Process the instructions with robo-santa"
      day3Service.processInstructionsWithRoboSanta(instructions)
    then: "We expect 17 houses visited"
      day3Service.houses.size() == 17
  }

}
