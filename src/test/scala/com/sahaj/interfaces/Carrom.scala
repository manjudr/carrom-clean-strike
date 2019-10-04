package com.sahaj.interfaces

import com.sahaj.managers.CoinsDashBoard
import com.sahaj.services.{GameStatus, User}

trait Carrom {
  def reset(): Unit

  def strike(user: User): CoinsDashBoard

  def multiStrike(user: User): CoinsDashBoard

  def redStrike(user: User): CoinsDashBoard

  def strikerStrike(user: User): CoinsDashBoard

  def defunctCoin(user: User): CoinsDashBoard

  def getGameStatus(user: User): GameStatus


}
