package com.sahaj.managers


case class CoinsDashBoard(score: Option[Int], userRedCoins: Option[Int], userBlockCoins: Option[Int], remainingBlockCoins: Option[Int], remainingRedCoins: Option[Int])


object StateManager {
  var redCoin: Int = 1
  var blackCoin: Int = 9


  def updateState(state: CoinsDashBoard): Unit = {
    this.redCoin = state.remainingRedCoins.getOrElse(1)
    this.blackCoin = state.remainingBlockCoins.getOrElse(9)
  }

  def getState: CoinsDashBoard = {
    CoinsDashBoard(None, None, None, Some(this.redCoin), Some(this.blackCoin))
  }

  def resetState(): Unit = {
    this.redCoin = 1
    this.blackCoin = 9
  }
}
