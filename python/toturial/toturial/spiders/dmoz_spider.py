import scrapy
import json
import codecs
from scrapy.contrib.spiders import Rule
from ..items import ToturialItem

class DmozSpider(scrapy.Spider):
    name = "tencent"
    allowed_domains = ["tencent.com"]
    start_urls = [
        "http://hr.tencent.com/position.php"
    ]

    def parse(self, response):
        filename ="f:\\1.json"
        f = codecs.open(filename, "w", encoding='utf-8')
        # f = open(filename, "w")
        sel = response.selector
        sites = sel.css("table.tablelist tr.even") + sel.css("table.tablelist tr.odd")
        # items = []
        for site in sites:
            item = ToturialItem()
            item['name'] = site.css(".l.square a").xpath("text()").extract()[0]
            item['type'] = site.css("tr > td:nth-child(2)::text").extract()[0]
            item['peopleNum'] = site.css("tr > td:nth-child(3)::text").extract()[0]
            item['workPosition'] = site.css("tr > td:nth-child(4)::text").extract()[0]
            item['publishTime'] = site.css("tr > td:nth-child(5)::text").extract()[0]
            # items.append(item)
            line = json.dumps(dict(item), ensure_ascii=False)
            f.write(line)
            yield item

        f.close()
