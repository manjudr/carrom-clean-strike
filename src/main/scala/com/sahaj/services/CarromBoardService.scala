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
    StateManager.resetState()
  }

  override def strike(player: Player): Unit = {
    val status = RuleManager.validate(player, "STRIKE")
    StateManager.updateState(status)
  }

  override def multiStrike(player: Player): Unit = {
    val status = RuleManager.validate(player, "MULTI_STRIKE")
    StateManager.updateState(status)
  }

  override def redStrike(player: Player): Unit = {
    val status = RuleManager.validate(player, "RED_STRIKE")
    StateManager.updateState(status)
  }

  override def strikerStrike(player: Player): Unit = {
    val status = RuleManager.validate(player, "STRIKER_STRIKE")
    StateManager.updateState(status)
  }

  override def defunctCoin(player: Player): Unit = {
    val status = RuleManager.validate(player, "DEFUNCT_COIN")
    StateManager.updateState(status)
  }

  override def getGameStatus(player: Player): GameStatus = {
    RuleManager.gameStatus(player)
  }

  def showScoreBoard(player: Player): Unit = {
    DashBoardManager.showInDashBoard(this.getGameStatus(player))
  }

  def failedHit(player: Player): CoinsDashBoard = {
    RuleManager.validate(player, "FAILED_HIT")
  }

  def isMatchWon: Boolean = {
    matchStatus
  }

  def hit(hitType: Choices, player: Player): Unit = {
    hitType.number match {
      case 1 => strike(player)
      case 2 => multiStrike(player)
      case 3 => redStrike(player)
      case 4 => strikerStrike(player)
      case 5 => defunctCoin(player)
      case 6 => failedHit(player)
      case _ => println("INVALID OPTION:" + hitType.number)

    }
  }

}
