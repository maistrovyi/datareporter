package core

import info.mukel.telegrambot4s.api.declarative.Commands
import info.mukel.telegrambot4s.api.{Polling, TelegramBot}

object ReporterBot extends TelegramBot with Polling with Commands {

  override lazy val token = "451570869:AAEyTxoJ2oXkYccs5GHld6_CUQtXxDMC2PI"

  /*@Inject
  lazy val userService = DefaultUserService*/

  onCommand('hi) {
    implicit msg => reply("Hi, this is awesome Scala!")
  }

  ReporterBot.run()

}