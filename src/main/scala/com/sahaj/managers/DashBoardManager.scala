package com.sahaj.managers

import com.sahaj.services.{GameStatus, Player}

case class Choices(number: Int)

/**
  * Dashboard Manager is responsible for displaying the information(score)/ reading the Information
  */


object DashBoardManager {

  /**
    * Read the input data from players
    *
    * @return - Option/Choice Number - Which option is selected from the player
    */
  def readInput(): Choices = {
    val input = scala.io.StdIn.readInt()
    Choices(input)
  }


  /**
    * Display All supported options to player
    *
    * @param player - Show the options to particular user
    * @return - Read the input from the player - Choice
    */
  def promptChoices(player: Player): Choices = {
    println(player.identifier.toUpperCase() + ": IT'S YOUR TURN, PLEASE SELECT THE CHOICE NUMBER")
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

  /**
    * Display - userId, status, score, won-status of the particular player
    *
    * @param board - Game status info
    */
  def showInDashBoard(board: GameStatus): Unit = {
    println("=============================")
    println("USER ID:" + board.userId)
    println("STATUS:" + board.status)
    println("SCORE:" + board.score)
    println("WON:" + board.active)
    println("=============================")

  }

  /**
    * Reset dashboard - erase all information
    */
  def resetGame(): Unit = {
    // reset dashboard logic
  }


}
