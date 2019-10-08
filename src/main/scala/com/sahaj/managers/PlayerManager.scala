package com.sahaj.managers

import com.sahaj.services.{CarromBoardService, Player}

object PlayerManager {
  def registerUser(playerIdentifier: String): Player = {
    new Player(playerIdentifier)
  }

  def resetUser(player: Player): Unit = {
    player.reset()
  }

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
}
