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
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def multiStrikeValidate(user: User): CoinsDashBoard = {
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def redStrikeValidate(user: User): CoinsDashBoard = {
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def strikerStrikeValidate(user: User): CoinsDashBoard = {
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def defunctCoinValidate(user: User): CoinsDashBoard = {
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def gameStatus(user: User): GameStatus = {
    GameStatus("WON", 10, user.identifier)
  }
}
