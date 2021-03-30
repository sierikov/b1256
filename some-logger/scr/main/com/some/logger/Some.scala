package com.some.logger

import com.typesafe.scalalogging.Logger

object Main {
  private val logger = Logger(this.getClass)
  def main(): Unit = {
    logger.info(s"This is a simple log line")
  }
}
