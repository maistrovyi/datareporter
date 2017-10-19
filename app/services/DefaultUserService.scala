package services

import javax.inject.{Inject, Singleton}

import models.User

trait UserService {
  def save(user: User): User
}

@Singleton
class DefaultUserService(@Inject() userStorage: UserStorage) extends UserService {

  override def save(user: User): User = {
    this.userStorage.save(user).get
  }

}