package com.sahaj.managers

import com.sahaj.services.{GameStatus, User}

case class Choices(number: Int)

object DashBoardManager {

  def readInput(): Choices = {
    val input = scala.io.StdIn.readInt()
    Choices(input)
  }


  def promptChoices(user: User): Choices = {
    println(user.identifier + ": Please select the below one choice")
    println("1. STRIKE")
    println("2. MULTI_STRIKE")
    println("3. RED_STRIKE")
    println("4. STRIKER_STRIKE")
    println("5. DEFUNCT_COIN")
    println("6. NONE")
    println("7. EXIT")
    val response = this.readInput()
    Choices(response.number)
  }

  def showInDashBoard(board: GameStatus) = {
    println("=============================")
    println("USER ID:" + board.userId)
    println("STATUS:" + board.status)
    println("SCORE:" + board.score)
    println("WON:" + board.active)
    println("=============================")

  }

  def resetGame(): Unit = {
    StateManager.resetState()
    // PlayerManager.resetUser()
  }


}
