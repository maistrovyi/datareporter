package core

import info.mukel.telegrambot4s.api._
import info.mukel.telegrambot4s.methods._
import info.mukel.telegrambot4s.models._

class ReporterBot(token: String) extends AbstractBot(token) with Polling {

  override def receiveMessage(msg: Message): Unit = {
    for (text <- msg.text)
      request(SendMessage(msg.source, "response: " + text))
  }

}