import requests
if __name__ == '__main__':
    r = requests.get("http://github.com/timeline.json")
    print(r)
    print(r.text)
    print(r.url)
    print(r.json)
    help(r)
    with open("timeline.json", "wb") as f:
        for chunk in r.iter_content(10):
            f.write(chunk)
    f.close()
    # r = requests.post("https://github.com/timeline.json")
    # print(r)
    # r = requests.delete("https://github.com/timeline.json")
    # print(r)
    # r = requests.head("https://github.com/timeline.json")
    # print(r)
    # r = requests.options("https://github.com/timeline.json")
    # print(r)
    pic = requests.get("http://image.tianjimedia.com/uploadImages/2016/113/19/6080QQNW991L.jpg")
    with open("1.jpg", "wb") as f:
        f.write(pic.content)
    f.close()
