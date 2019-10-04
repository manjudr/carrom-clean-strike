package com.sahaj.services

import com.sahaj.interfaces.Carrom
import com.sahaj.managers._

/**
  * status - won,draw,lose,pending,userRedCoins, userBlockCoins, Score, remainingBlackCoins,remainingRedCoins
  *
  * @param status
  */


case class GameStatus(status: String, score: Int, userId: String, active: String)

class CarromBoardService extends Carrom {
  var matchStatus: Boolean = false

  override def reset(): Unit = {
    DashBoardManager.resetGame()
  }

  override def strike(user: Player): Unit = {
    val status = RuleManager.validate(user, "STRIKE")
    StateManager.updateState(status)
  }

  override def multiStrike(user: Player): Unit = {
    val status = RuleManager.validate(user, "MULTI_STRIKE")
    StateManager.updateState(status)
  }

  override def redStrike(user: Player): Unit = {
    val status = RuleManager.validate(user, "RED_STRIKE")
    StateManager.updateState(status)
  }

  override def strikerStrike(user: Player): Unit = {
    val status = RuleManager.validate(user, "STRIKER_STRIKE")
    StateManager.updateState(status)
  }

  override def defunctCoin(user: Player): Unit = {
    val status = RuleManager.validate(user, "DEFUNCT_COIN")
    StateManager.updateState(status)
  }

  override def getGameStatus(user: Player): GameStatus = {
    RuleManager.gameStatus(user)
  }

  def showScoreBoard(user: Player): Unit = {
    DashBoardManager.showInDashBoard(this.getGameStatus(user))
  }

  def defFailedHit(user: Player): CoinsDashBoard = {
    RuleManager.failedHit(user)
  }

  def isMatchWon: Boolean = {
    matchStatus
  }

  def hit(hitType: Choices, user: Player): Unit = {
    hitType.number match {
      case 1 => strike(user)
      case 2 => multiStrike(user)
      case 3 => redStrike(user)
      case 4 => strikerStrike(user)
      case 5 => defunctCoin(user)
      case 6 => defFailedHit(user)

    }
  }

}
