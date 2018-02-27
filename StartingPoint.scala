package MyWebCrawler

import akka.actor.{ActorSystem, PoisonPill, Props}
import java.net.URL
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps

object StartingPoint extends App {
  val system = ActorSystem()
  val supervisor = system.actorOf(Props(new Supervisor(system)))

  supervisor ! Start(new URL("http://mail-archives.apache.org/mod_mbox/maven-users/"))

  Await.result(system.whenTerminated, 10 minutes)

  supervisor ! PoisonPill
  system.terminate
}
