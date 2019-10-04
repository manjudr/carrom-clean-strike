package com.sahaj.services

case class userSpec(var identifier: String, redCoins: Int, blockCoins: String, status: String, score: Int)

class User(userId: String) {
  var redCoins: Int = 0
  var blockCoins: Int = 0
  var score: Int = 0
  var status: String = "PENDING"
  var identifier: String = userId

  def reset(): Unit = {
    this.redCoins = 0
    this.blockCoins = 0
    this.score = 0
    this.status = "PENDING"

  }

}
