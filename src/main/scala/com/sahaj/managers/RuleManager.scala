package com.sahaj.managers


import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.sahaj.services.{AppConfig, GameStatus, Player}

case class Rules(ruleType: String, score: Int, strikedBlockCoins: Int, strikedRedCoins: Int, invalidAttempt: Int, playingStatus: String, maxAttempts: Option[Int])

case class Attributes(points: Int, blockCoins: Int, redCoins: Int, status: String, attempts: Int)

object RuleManager {

  def getRules(ruleType: String): Rules = {
    val mapper = new ObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val rules: Array[Rules] = mapper.readValue(AppConfig.getConfig("com.sahaj.rules"), classOf[Array[Rules]])
    rules.filter(r => r.ruleType == ruleType).head
  }

  def validate(player: Player, command: String): CoinsDashBoard = {
    command match {
      case "STRIKE" => strike(player, command)
      case "MULTI_STRIKE" => strike(player, command)
      case "RED_STRIKE" => strike(player, command)
      case "STRIKER_STRIKE" => strike(player, command)
      case "DEFUNCT_COIN" => strike(player, command)
      case "FAILED_HIT" => failedHit(player, command)
    }
  }

  def strike(player: Player, command: String): CoinsDashBoard = {
    val rules: Rules = this.getRules(command)
    val updatedValues = update(player, Attributes(rules.score, rules.strikedBlockCoins, rules.strikedRedCoins, rules.playingStatus, rules.invalidAttempt))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def failedHit(player: Player, command: String): CoinsDashBoard = {
    println("failedHit")
    val rules: Rules = this.getRules(command)
    var score = 0
    var status = "ACTIVE"
    if (player.attempts == rules.maxAttempts.getOrElse(3)) {
      score += rules.score
      status = rules.playingStatus
    } else {
      player.attempts += 1
    }
    val updatedValues = update(player, Attributes(score, rules.strikedBlockCoins, rules.strikedRedCoins, status, player.attempts))
    val remaningBlackCoins = StateManager.blackCoin - updatedValues.blockCoins
    val remaningRedkCoins = StateManager.redCoin - updatedValues.redCoins
    CoinsDashBoard(Some(updatedValues.score), Some(updatedValues.redCoins), Some(updatedValues.blockCoins), Some(remaningBlackCoins), Some(remaningRedkCoins))
  }

  def gameStatus(player: Player): GameStatus = {
    GameStatus(player.status, player.score, player.identifier, player.wonStatus)
  }

  def update(player: Player, attribute: Attributes): Player = {
    player.score += attribute.points
    player.redCoins = attribute.redCoins
    player.status = attribute.status
    player.blockCoins = attribute.blockCoins
    player
  }
}

