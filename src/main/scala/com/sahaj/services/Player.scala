package com.sahaj.services

case class PlayerSpec(var identifier: String, redCoins: Int, blockCoins: String, status: String, score: Int, wonStatus: String)

class Player(userId: String) {
  var identifier: String = userId
  private var redCoins: Int = 0
  private var blockCoins: Int = 0
  private var score: Int = 0
  private var wonStatus = "PENDING"
  private var status: String = "ACTIVE"
  private var attempts: Int = 0

  def getScore: Int = {
    this.score
  }

  def setScore(score: Int): Unit = {
    this.score = score
  }

  def getAttempts: Int = {
    this.attempts
  }

  def setAttempts(attempt: Int): Unit = {
    this.attempts = attempt
  }

  def getStatus: String = {
    this.status
  }

  def setStatus(status: String): Unit = {
    this.status = status
  }

  def getRedCoins: Int = {
    this.redCoins
  }

  def setRedCoins(redCoins: Int): Unit = {
    this.redCoins = redCoins
  }

  def getBlackCoins: Int = {
    this.blockCoins
  }

  def setBlackCoins(blackCoins: Int): Unit = {
    this.blockCoins = blackCoins
  }

  def setWonStatus(status: String): Unit = {
    this.wonStatus = status
  }

  def getWonStatus: String = {
    this.wonStatus
  }

  def reset(): Unit = {
    this.redCoins = 0
    this.blockCoins = 0
    this.score = 0
    this.status = "PENDING"
    this.attempts = 0
  }

  def restStatus(status: String): Unit = {
    this.status = status
  }


}
