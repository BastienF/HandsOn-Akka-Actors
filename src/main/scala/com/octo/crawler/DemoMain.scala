package com.octo.crawler

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.octo.crawler.crawling.CrawlActor

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._


object DemoMain {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("CrawlerSystem")
    val crawlActor = system.actorOf(Props[CrawlActor])
    implicit val timeout = Timeout(30 second)
    val reponse = crawlActor ? CrawlActor.ExecuteHTTPRequest("https://en.wikipedia.org/wiki/Main_Page")
    reponse.onComplete(httpResponse => {
      println(httpResponse)
      system.shutdown()
    })
  }
}
