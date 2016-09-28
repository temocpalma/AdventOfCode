package com.advent

import spock.lang.Specification

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

  def "When instruction is > and previous instruction is not opposite should delivers presents to 2 houses"() {
    given:"The > instruction"
      String instruction = ">"
    when:
      adventOfCode.processInstruction(instruction)
    then:
      adventOfCode.visited == 2
  }

  def "When instruction is ^>v< and previous instruction is not opposite should delivers presents to 4 houses"() {
    given:"The > instruction"
      String instruction = "^>v<"
    when:
      adventOfCode.processInstruction(instruction)
    then:
      adventOfCode.visited == 4
  }

}
