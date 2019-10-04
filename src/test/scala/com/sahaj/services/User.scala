package com.sahaj.services

case class userSpec(var identifier: String, redCoins: Int, blockCoins: String, status: String, score: Int, wonStatus: String)

class User(userId: String) {
  var redCoins: Int = 0
  var blockCoins: Int = 0
  var score: Int = 0
  var wonStatus = "PENDING"
  var status: String = "ACTIVE"
  var identifier: String = userId
  var attempts: Int = 0

  def reset(): Unit = {
    this.redCoins = 0
    this.blockCoins = 0
    this.score = 0
    this.status = "PENDING"
    this.attempts = 0
  }

  def resetAttempts(): Unit = {
    this.attempts = 0
  }

  def updateAttempts(number: Int): Unit = {
    this.attempts = number
  }

  def restStatus(status:String): Unit ={
    this.status = status
  }


}
