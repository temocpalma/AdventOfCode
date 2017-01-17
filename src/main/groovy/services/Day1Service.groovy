package com.advent

class Day1Service {
  Long initialFloor = 0

  Long executeInstructions(String instructions) {
    Long countUp = instructions.count("(")
    Long countDown = instructions.count(")")
    countUp-countDown
  }
}
