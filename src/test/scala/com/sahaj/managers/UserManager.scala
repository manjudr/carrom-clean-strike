package com.sahaj.managers

import com.sahaj.services.User

object UserManager {
  def registerUser(userIdentifier: String): User = {
    new User(userIdentifier)
  }

  def updateUserState(user: User, state: CoinsDashBoard): Unit = {
  }

  def resetUser(user: User): Unit = {
    user.reset()
  }

}
