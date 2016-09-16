package com.octo.crawler.crawling

import akka.actor._
import com.octo.crawler.AkkaWorkflowExceptions.WrongMessageException
import com.octo.crawler.crawling.CrawlActor.ExecuteHTTPRequest

import scalaj.http.{Http, HttpOptions, HttpResponse}

class CrawlActor() extends Actor {

  override def receive: Receive = {
    case ExecuteHTTPRequest(url) => sender() ! crawlUrl(url)
    case x => throw WrongMessageException(x, sender())
  }

  def crawlUrl(url: String): HttpResponse[String] = {
    val response: HttpResponse[String] =
      Http(url).option(HttpOptions.allowUnsafeSSL).asString
    response
  }
}

object CrawlActor {

  sealed trait CrawlActorMessage

  case class ExecuteHTTPRequest(url: String) extends CrawlActorMessage

}




