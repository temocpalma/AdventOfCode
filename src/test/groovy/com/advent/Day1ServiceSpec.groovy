package com.advent

import spock.lang.Specification
import spock.lang.Unroll

class Day1ServiceSpec extends Specification {

  Day1Service day1Service = new Day1Service()

  @Unroll
  void "Should to be in floor #floor when instructions are #instructions"() {
    when:"Process the instructions"
      def currentFloor = day1Service.executeInstructions(instructions)
    then:"Expect floor"
      currentFloor == floor
    where:
    instructions    ||    floor
    "(())"          ||      0
    "()()"          ||      0
    "((("           ||      3
    "(()(()("       ||      3
    "))((((("       ||      3
    "())"           ||      -1
    "))("           ||      -1
    ")))"           ||      -3
    ")())())"       ||      -3
  }

}
