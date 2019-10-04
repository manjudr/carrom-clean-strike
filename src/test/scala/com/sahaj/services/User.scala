package com.sahaj.services

case class userSpec(var identifier: String, redCoins: Int, blockCoins: String, status: String)

class User(userId: String) {
  var redCoins: Int = 0
  var blockCoins: Int = 0
  var status: String = "PENDING"
  var identifier: String = userId

  //  def this(identifier: String) {
  //    this(identifier)
  //  }

  def reset(): Unit = {
    this.redCoins = 0
    this.blockCoins = 0
    this.status = "PENDING"

  }

}
