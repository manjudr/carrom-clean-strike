package com.sahaj.services

import com.typesafe.config.{Config, ConfigFactory}

object AppConfig {
  lazy val defaultConf: Config = ConfigFactory.load()
  lazy val envConf: Config = ConfigFactory.systemEnvironment()
  lazy val conf: Config = defaultConf.withFallback(envConf)

  def getConfig(key: String): String = {
    if (conf.hasPath(key))
      conf.getString(key)
    else ""
  }
}