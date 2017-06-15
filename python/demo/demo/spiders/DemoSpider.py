import scrapy
import json
import codecs
from ..items import DemoItem

class DemoSpider(scrapy.Spider):
    name = "demo"
    start_urls = ["http://hr.tencent.com/position.php"]

    def parse(self, response):
        sel = response.selector
        items = sel.css("table.tablelist tr.even") +sel.css("table.tablelist tr.odd")
        file = codecs.open("demo.json", "w", encoding="utf-8")
        for item in items:
            demoItem = DemoItem()
            demoItem['name'] = item.css(".l.square a::text").extract_first()
            demoItem['link'] = item.css(".l.square a").xpath("@href").extract_first()
            demoItem['type'] = item.css("tr > td:nth-child(2)::text").extract_first()
            demoItem['applyNum'] = item.css("tr > td:nth-child(3)::text").extract_first()
            demoItem['wordPosition'] = item.css("tr > td:nth-child(4)::text").extract_first()
            demoItem['publicTime'] = item.css("tr > td:nth-child(5)::text").extract_first()
            line = json.dumps(dict(demoItem), ensure_ascii=False) + "\n"
            print(line)
            file.write(line)

        file.close()
