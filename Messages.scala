package MyWebCrawler

import java.net.URL


case class Start(url: URL)
case class Scrap(url: URL)
case class Index(url: URL, content: Content)
case class Content(title: String, meta: String, urls: List[URL])
case class ScrapFinished(url: URL)
case class IndexFinished(url: URL, urls: List[URL])
case class ScrapFailure(url: URL, reason: Throwable)