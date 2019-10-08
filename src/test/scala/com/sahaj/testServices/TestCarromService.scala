package com.sahaj.testServices

import com.sahaj.managers.PlayerManager
import com.sahaj.services.CarromBoardService

class TestCarromService extends BaseSpec {
  prepareTest()

  "CarromBoard Service" - {


    "When The player strike the coin" - {
      "Player1 should win a points" in {
        /**
          * GIVEN:
          *  1.Fresh carrom board
          *  2. Register two new player
          */

        val carrom = new CarromBoardService()
        carrom.reset() // Carrom board to fresh status

        // Register two player to play the game.
        var player1 = PlayerManager.registerUser("Manjunath Davanam")
        var player2 = PlayerManager.registerUser("Maria Irudayam")


        carrom.strike(player1)
        val result = carrom.getGameStatus(player1)
        assert(result.score === 1)
        assert(result.userId === "Manjunath Davanam")
      }
    }

    "When a player pockets more than one coin (Multi-strike)" - {
      "Player1 should win a more than 2 points" in {
        /**
          * GIVEN:
          *  1.Fresh carrom board
          *  2. Register two new player
          */

        val carrom = new CarromBoardService()
        carrom.reset() // Carrom board to fresh status

        // Register two player to play the game.
        var player1 = PlayerManager.registerUser("Manjunath Davanam")
        var player2 = PlayerManager.registerUser("Maria Irudayam")

        carrom.multiStrike(player2)
        val result = carrom.getGameStatus(player2)
        assert(result.score === 2)
        assert(result.userId === "Maria Irudayam")
      }
    }

    "When a player pockets red coin (Red strike)" - {
      "Player should wins 3 points" in {
        /**
          * GIVEN:
          *  1.Fresh carrom board
          *  2. Register two new player
          */

        val carrom = new CarromBoardService()
        carrom.reset() // Carrom board to fresh status

        // Register two player to play the game.
        var player1 = PlayerManager.registerUser("Manjunath Davanam")
        var player2 = PlayerManager.registerUser("Maria Irudayam")

        carrom.redStrike(player2)
        val result = carrom.getGameStatus(player2)
        assert(result.score === 3)
        assert(result.userId === "Maria Irudayam")
      }
    }


    "When a player pockets the striker (Striker strike)" - {
      "Player should lose a point" in {
        /**
          * GIVEN:
          *  1.Fresh carrom board
          *  2. Register two new player
          */

        val carrom = new CarromBoardService()
        carrom.reset() // Carrom board to fresh status

        // Register two player to play the game.
        var player1 = PlayerManager.registerUser("Manjunath Davanam")
        var player2 = PlayerManager.registerUser("Maria Irudayam")

        carrom.strikerStrike(player2)
        val result = carrom.getGameStatus(player2)
        assert(result.score === -1)
        assert(result.userId === "Maria Irudayam")
      }
    }


    "When a coin is thrown out of the carrom-board, due to a strike (Defunct coin -)" - {
      "Player should lose a point" in {
        /**
          * GIVEN:
          *  1.Fresh carrom board
          *  2. Register two new player
          */

        val carrom = new CarromBoardService()
        carrom.reset() // Carrom board to fresh status

        // Register two player to play the game.
        var player1 = PlayerManager.registerUser("Manjunath Davanam")
        var player2 = PlayerManager.registerUser("Maria Irudayam")

        carrom.defunctCoin(player2)
        val result = carrom.getGameStatus(player2)
        assert(result.score === -2)
        assert(result.userId === "Maria Irudayam")
      }
    }


    "When a player does not pocket a coin for 3 successive turns (None)" - {
      "Player should lose a point" in {
        /**
          * GIVEN:
          *  1.Fresh carrom board
          *  2. Register two new player
          */

        val carrom = new CarromBoardService()
        carrom.reset() // Carrom board to fresh status

        // Register two player to play the game.
        var player1 = PlayerManager.registerUser("Manjunath Davanam")
        var player2 = PlayerManager.registerUser("Maria Irudayam")
        var hit = 0

        // for loop execution with a range
        for (hit <- 0 to 3) {
          carrom.failedHit(player2)
        }
        val result = carrom.getGameStatus(player2)
        assert(result.score === -1)
        assert(result.userId === "Maria Irudayam")
      }
    }
  }
}