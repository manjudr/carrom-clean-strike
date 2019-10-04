package com.sahaj.managers

import com.sahaj.services.{CarromBoardService, User}

object PlayerManager {
  def registerUser(userIdentifier: String): User = {
    new User(userIdentifier)
  }

  def resetUser(user: User): Unit = {
    user.reset()
  }

  def play(player1: User, player2: User, carrom: CarromBoardService): Unit = {
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
