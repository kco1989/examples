package com.kco.springmvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by Administrator on 2017/7/28.
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getDeferredResult() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh(){
        if (deferredResult != null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
