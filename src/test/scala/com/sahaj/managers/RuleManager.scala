package com.sahaj.managers

import com.sahaj.services.{GameStatus, User}

object RuleManager {
  def validate(user: User, command: String): CoinsDashBoard = {
    CoinsDashBoard(Some(10), Some(1), Some(5), Some(2), Some(4))
  }

  def gameStatus(user: User): GameStatus = {
    GameStatus("WON", 10, user.identifier)
  }
}
