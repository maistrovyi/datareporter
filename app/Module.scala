import java.time.Clock

import com.google.inject.AbstractModule
import core.ReporterBot
import services.{ApplicationTimer, AtomicCounter, Counter}

import scala.io.Source

class Module extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[Clock]).toInstance(Clock.systemUTC())
    bind(classOf[ApplicationTimer]).asEagerSingleton()
    bind(classOf[Counter]).to(classOf[AtomicCounter])
    val tokenPath = System.getProperty("user.dir") + "/conf/bot.token"
    val token = scala.util.Properties
      .envOrNone("BOT_TOKEN")
      .getOrElse(Source.fromFile(tokenPath).getLines().mkString)
    new ReporterBot(token).run()
  }

}