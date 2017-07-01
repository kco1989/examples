import scrapy
from ..items import Kk7Item
from urllib.parse import urljoin

class kk7Spider(scrapy.Spider):
    name = "kk7"
    allowed_domains = ["7kk.com"]
    start_urls = ["http://www.7kk.com/picture/3058747.html"]
    base_url = "http://www.7kk.com/picture/3058747.html"
    count = 0
    def parse(self, response):
        item = Kk7Item()
        item["url"] = response.css("a.bizhi-img img::attr(src)").extract_first()
        item["fileName"] = item['url'].split("/")[-1]
        yield item
        href = response.css("a#nextTop.btn.next::attr(href)").extract_first()
        nextUrl = urljoin(self.base_url, href)
        self.count = self.count + 1
        if self.count < 1000:
            yield scrapy.Request(nextUrl)