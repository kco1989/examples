import scrapy
import json
import codecs
from ..items import MyItem

class DemoSpider(scrapy.Spider):
    name = "pythontab"
    allowed_domains=['pythontab.com']
    start_urls = [
        "http://docs.pythontab.com/scrapy/scrapy0.24/"
    ]

    base_url = "http://docs.pythontab.com/scrapy/scrapy0.24/"
    def parse(self, response):
        sel = response.selector
        items = sel.css(".toctree-l1 a") + sel.css(".toctree-l2 a")
        file = codecs.open("pythontab2.json", "w", encoding="utf-8")
        for item in items:
            demoItem = MyItem()
            demoItem['title'] = item.css('a').xpath("text()").extract_first()
            url = self.base_url + item.css("a").xpath("@href").extract_first()
            demoItem['url'] = url
            line = json.dumps(dict(demoItem), ensure_ascii=False) + "\n"
            print(line)
            file.write(line)
            yield scrapy.Request(url, callback=self.parse)
        file.close()
