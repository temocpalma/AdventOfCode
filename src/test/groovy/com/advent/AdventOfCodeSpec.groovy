package com.advent

import spock.lang.Specification

class AdventOfCodeSpec extends Specification {


  def "When instruction is > should delivers presents to 2 houses"() {
    given:"The > instruction"
      AdventOfCode adventOfCode = new AdventOfCode()
      String instruction = ">"
    when:
      adventOfCode.processInstruction(instruction)
    then:
      adventOfCode.visitedHouse.size == 2
  }
}
