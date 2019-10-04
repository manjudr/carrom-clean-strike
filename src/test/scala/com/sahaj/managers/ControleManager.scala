package com.sahaj.managers

import com.sahaj.services.{GameStatus, User}

case class Choices(number: Int)

object ControleManager {

  def readInput(): Choices = {
    val input = scala.io.StdIn.readInt()
    Choices(input)
  }

  def getNextPlayer(): User = {
    null
  }

  def promptChoices(): Choices = {
    println("1. STRIKE")
    println("2. MULTI_STRIKE")
    println("3. RED_STRIKE")
    println("4. STRIKER_STRIKE")
    println("5. DEFUNCT_COIN")
    println("6. NONE")
    val response = this.readInput()
    Choices(response.number)
  }

  def showInDashBoard(board: GameStatus) = {
    println("USER ID:", board.userId)
    println("STATUS:", board.status)
    println("SCORE:", board.score)

  }

  def resetGame(): Unit ={
    StateManager.resetState()
   // UserManager.resetUser()
  }


}
