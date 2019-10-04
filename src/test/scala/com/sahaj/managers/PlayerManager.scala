package com.sahaj.managers

import com.sahaj.services.{CarromBoardService, Player}

object PlayerManager {
  def registerUser(userIdentifier: String): Player = {
    new Player(userIdentifier)
  }

  def resetUser(user: Player): Unit = {
    user.reset()
  }

  def play(player1: Player, player2: Player, carrom: CarromBoardService): Unit = {
    while (!carrom.isMatchWon) {
      val activePlayer = if (player1.status == "ACTIVE") {
        player2.restStatus("ACTIVE")
        player1
      } else {
        player1.restStatus("ACTIVE")
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

}
