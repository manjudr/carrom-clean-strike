package com.sahaj.managers


import com.sahaj.services.{GameStatus, User}


case class Attributes(points: Int, blockCoins: Int, redCoins: Int, status: String, attempts: Int)

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
    val score = 1
    val blockCoins = 1
    val redCoins = 0
    val status = "ACTIVE"
    val InvalidAttempt = 0
    val updatedValues = update(user, Attributes(score, blockCoins, redCoins, status, InvalidAttempt))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def multiStrikeValidate(user: User): CoinsDashBoard = {
    val score = 2
    val blockCoins = 2
    val redCoins = 0
    val status = "ACTIVE"
    val InvalidAttempt = 0
    val updatedValues = update(user, Attributes(score, blockCoins, redCoins, status, InvalidAttempt))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def redStrikeValidate(user: User): CoinsDashBoard = {

    val score = 3
    val blockCoins = 0
    val redCoins = 1
    val status = "ACTIVE"
    val InvalidAttempt = 0
    val updatedValues = update(user, Attributes(score, blockCoins, redCoins, status, InvalidAttempt))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def strikerStrikeValidate(user: User): CoinsDashBoard = {
    val score = -1
    val blockCoins = 0
    val redCoins = 0
    val status = "INACTIVE"
    val InvalidAttempt = 0
    val updatedValues = update(user, Attributes(score, blockCoins, redCoins, status, InvalidAttempt))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def defunctCoinValidate(user: User): CoinsDashBoard = {
    val score = -3
    val blockCoins = 0
    val redCoins = 0
    val status = "INACTIVE"
    val InvalidAttempt = 0
    val updatedValues = update(user, Attributes(score, blockCoins, redCoins, status, InvalidAttempt))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def failedHit(user: User): CoinsDashBoard = {
    var score = 0
    val blockCoins = 0
    val redCoins = 0
    var status = "ACTIVE"
    if (user.attempts == 3) {
      score += -1
      status = "INACTIVE"
    } else {
      user.attempts += 1
    }
    val updatedValues = update(user, Attributes(score, blockCoins, redCoins, status, user.attempts))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins

    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def gameStatus(user: User): GameStatus = {
    GameStatus(user.status, user.score, user.identifier, user.wonStatus)
  }

  def update(user: User, attribute: Attributes): User = {
    user.score += attribute.points
    user.redCoins = attribute.redCoins
    user.status = attribute.status
    user.blockCoins = attribute.blockCoins
    user
  }
}
