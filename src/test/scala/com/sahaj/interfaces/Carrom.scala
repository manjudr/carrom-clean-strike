package com.sahaj.interfaces

import com.sahaj.managers.CoinsDashBoard
import com.sahaj.services.{GameStatus, User}

trait Carrom {
  def reset(): Unit

  def strike(user: User): Unit

  def multiStrike(user: User): Unit

  def redStrike(user: User): Unit

  def strikerStrike(user: User): Unit

  def defunctCoin(user: User): Unit

  def getGameStatus(user: User): GameStatus


}
