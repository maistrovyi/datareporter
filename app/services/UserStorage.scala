package services

import javax.inject.Singleton
import models.User
import scala.collection.mutable

@Singleton
class UserStorage {

  val map = new mutable.HashMap[String, User]

  def save(user: User): Option[User] = {
    map.put(user.id, user)
    findById(user.id)
  }

  def findById(id: String): Option[User] = map.get(id)

}