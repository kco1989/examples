# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
import requests

class Kk7Pipeline(object):
    base_dir = "E:\\共享\\picture\\"
    def process_item(self, item, spider):
        print("=" * 20)
        print(item["url"])
        print(item["fileName"])
        print("=" * 20)
        resq = requests.get(item['url'])
        fileName = self.base_dir + item["fileName"]
        print(fileName)
        with open(fileName, "wb") as f:
            f.write(resq.content)
        return item
