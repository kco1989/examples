import requests

if __name__ == '__main__':
    loginUrl = "http://127.0.0.1:8882/agentweb2/perform_login.do"
    loginParam = {
        "username": '18998718665',
        "password": "123456",
        "teamid": "999"
    }
    s = requests.Session()
    loginResp = s.post(loginUrl, data=loginParam)
    print(loginResp)
    print(loginResp.text)

    url = "http://127.0.0.1:8882/agentweb2/agentInfo/editAgentInfoDetail"
    params = {
        "agentNo":  "1572",
        "teamId": "999"
    }
    r = s.post(url, json=params)
    print(r.text)

    url2 = "http://127.0.0.1:8882/agentweb2/agentInfo/queryAgentInfoList"
    jsonParams2 = {"hasSub":  0,"bool": "1","agentName": "1572"}
    dataParams2 = {
        "pageNo":  1,
        "pageSize": 10,
        "baseInfo": jsonParams2
    }
    r2 = s.post(url2, data=dataParams2)
    print(r2.text)
    print(r2.url)