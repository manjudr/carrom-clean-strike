package com.sahaj.managers

import com.sahaj.services.{GameStatus, User}

object RuleManager {
  def validate(user: User, command: String): CoinsDashBoard = {
    command match {
      case "STRIKE" => strikeValidate(user: User)
      case "MULTI_STRIKE" => multiStrikeValidate(user: User)
      case "RED_STRIKE" => redStrikeValidate(user: User)
      case "STRIKER_STRIKE" => strikerStrikeValidate(user: User)
      case "DEFUNCT_COIN" => defunctCoinValidate(user: User)
    }
  }

  def strikeValidate(user: User): CoinsDashBoard = {
    val addition_points = 1
    val block_coins = 1
    val negative_points = 0

    user.score += addition_points
    println(user.score)
    user.blockCoins += block_coins
    val remaningBlackCoins = StateManager.blackCoin - block_coins
    val remaningRedkCoins = StateManager.redCoin - user.redCoins
    CoinsDashBoard(Some(user.score), Some(user.redCoins), Some(user.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def multiStrikeValidate(user: User): CoinsDashBoard = {
    val addition_points = 2
    val negative_points = 0
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def redStrikeValidate(user: User): CoinsDashBoard = {
    val addition_points = 3
    val negative_points = 0
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def strikerStrikeValidate(user: User): CoinsDashBoard = {
    val addition_points = 0
    val negative_points = -1
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def defunctCoinValidate(user: User): CoinsDashBoard = {
    val addition_points = 0
    val negative_points = -3
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def gameStatus(user: User): GameStatus = {
    GameStatus(user.status, user.score, user.identifier, user.wonStatus)
  }
}
