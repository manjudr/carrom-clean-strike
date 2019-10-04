package com.sahaj.interfaces

import com.sahaj.managers.CoinsDashBoard
import com.sahaj.services.{GameStatus, Player}

trait Carrom {
  def reset(): Unit

  def strike(user: Player): Unit

  def multiStrike(user: Player): Unit

  def redStrike(user: Player): Unit

  def strikerStrike(user: Player): Unit

  def defunctCoin(user: Player): Unit

  def getGameStatus(user: Player): GameStatus


}
