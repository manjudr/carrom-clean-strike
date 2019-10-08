package com.sahaj.managers

import com.sahaj.services.{CarromBoardService, Player}

/**
  * PlayerManager - It controls the players, Which decides WHO and WHEN for the player.
  */

object PlayerManager {

  /**
    * Register the user to play the game
    *
    * @param playerIdentifier - Player identifier
    * @return - Player
    */
  def registerUser(playerIdentifier: String): Player = {
    new Player(playerIdentifier)
  }

  /**
    * Method allows to play the game between two users
    *
    * @param player1 - Player
    * @param player2 - Player
    * @param carrom  - Carom Board
    */

  def play(player1: Player, player2: Player, carrom: CarromBoardService): Unit = {
    val activePlayer = if (player1.getStatus == "ACTIVE") {
      player2.setStatus("ACTIVE")
      player1
    } else {
      player1.setStatus("ACTIVE")
      player2
    }
    val response: Choices = DashBoardManager.promptChoices(activePlayer)
    if (response.number != 7) {
      carrom.hit(response, activePlayer)
      carrom.showScoreBoard(activePlayer)
    } else {
      println("CLOSING THE GAME..")
      System.exit(0)
    }
  }

  /**
    * Method allows to reset the player
    *
    * @param player - Player
    */
  def resetUser(player: Player): Unit = {
    player.reset()
  }
}
