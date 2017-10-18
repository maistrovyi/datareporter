import java.time.Clock

import com.google.inject.AbstractModule
import core.ReporterBot
import services.{ApplicationTimer, AtomicCounter, Counter}

class Module extends AbstractModule {

  override def configure(): Unit = {
    bind(classOf[Clock]).toInstance(Clock.systemUTC())
    bind(classOf[ApplicationTimer]).asEagerSingleton()
    bind(classOf[Counter]).to(classOf[AtomicCounter])
    ReporterBot.run()
  }

}
