package com.sahaj.services

import com.sahaj.interfaces.Carrom
import com.sahaj.managers._

/**
  * status - won,draw,lose,pending,userRedCoins, userBlockCoins, Score, remainingBlackCoins,remainingRedCoins
  *
  * @param status
  */


case class GameStatus(status: String, score: Int, userId: String)

class CarromBoardService extends Carrom {

  override def reset(): Unit = {
    ControleManager.resetGame()
  }

  override def strike(user: User): CoinsDashBoard = {
    val gameStatus = RuleManager.gameStatus(user)
    val status = RuleManager.validate(user, "STRIKE")
    UserManager.updateUserState(user, status)
    StateManager.updateState(status)
    null
  }

  override def multiStrike(user: User) = {
    RuleManager.validate(user, "MULTI_STRIKE")
  }

  override def redStrike(user: User) = {
    RuleManager.validate(user, "RED_STRIKE")
  }

  override def strikerStrike(user: User) = {
    RuleManager.validate(user, "STRIKER_STRIKE")
  }

  override def defunctCoin(user: User): CoinsDashBoard = {
    RuleManager.validate(user, "DEFUNCT_COIN")
  }

  override def getGameStatus(user: User): GameStatus = {
    RuleManager.gameStatus(user)
  }

  def showScoreBoard(user: User): Unit = {
    ControleManager.showInDashBoard(this.getGameStatus(user))
  }

}
