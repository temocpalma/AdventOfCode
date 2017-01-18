package com.advent

class Day1Service {

  Long lastFloor(String instructions) {
    Long countUp = instructions.count("(")
    Long countDown = instructions.count(")")
    countUp-countDown
  }

  Long positionFirstTimeInBasement(String instructions) {
    Long floor = 0
    Long position = 0
    instructions.find {
      it=="(" ? floor++ : floor--
      position++
      if (floor == -1 ) return true
      return false
    }
    floor == -1 ? position : 0
  }
}
