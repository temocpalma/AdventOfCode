package com.advent

import spock.lang.Specification
import spock.lang.Unroll

class AdventOfCodeSpec extends Specification {

  AdventOfCode adventOfCode = new AdventOfCode()

  def "When instruction is > and previous is not opposite expect true"() {
    given:
      String instruction = ">"
    when:
      Boolean result = adventOfCode.instructionIsNotOppositeToPrevious(instruction)
    then:
      result == true
  }

  def "When instruction is > and previous is opposite expect false"() {
    given:
      String instruction = ">"
    and:
      adventOfCode.prevInstruction = "<"
    when:
      Boolean result = adventOfCode.instructionIsNotOppositeToPrevious(instruction)
    then:
      result == false
  }

  @Unroll
  def "When currentInstruction is #instr and currentHouse is (0,0) the new x house location should be #newX"() {
    given:
      String currentInstruction = instr
    and:
      adventOfCode = new AdventOfCode()
    when:
      int result = adventOfCode.getNewXLocation(currentInstruction)
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
      adventOfCode = new AdventOfCode()
    when:
      int result = adventOfCode.getNewYLocation(currentInstruction)
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
      adventOfCode.houses = [new House(x:0, y:1)]
    when:
      def result = adventOfCode.newHouseIsNotYetVisited(house)
    then:
      result == true
  }

  def "When new location exists in houses visted expect false"() {
    given:
      House house = new House(x:0, y:0)
    and:
      adventOfCode.houses = [new House(x:0, y:0)]
    when:
      def result = adventOfCode.newHouseIsNotYetVisited(house)
    then:
      result == false

  }

  def "When instruction is > and previous instruction is not opposite should delivers presents to 2 houses"() {
    given:"The > instruction"
      String instruction = ">"
      AdventOfCode advCod = new AdventOfCode()
    when:
      advCod.processInstruction(instruction)
    then:
      advCod.houses.size == 2
  }

  def "When instruction is ^>v< should delivers presents to 4 houses"() {
    given:"The > instruction"
      String instruction = "^>v<"
    when:
      adventOfCode.processInstruction(instruction)
    then:
      adventOfCode.houses.size == 4
  }

  @Unroll
  def "When instruction is #instr should delivers presents to #visited houses"() {
    given:
      String instruction = instr
    when:
      adventOfCode.processInstruction(instruction)
    then:
      adventOfCode.houses.size == visited
    where:
      instr | visited
      ">"   | 2
      "^>v<"| 4
      "^v^v^v^v^v"  | 2
      ">^^v^"  | 4
      ">^^v^<>v<<<v<v^>>v^^^<"  | 15
  }

}
