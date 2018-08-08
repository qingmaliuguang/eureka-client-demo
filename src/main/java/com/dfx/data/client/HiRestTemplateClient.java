package com.dfx.data.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by a123456 on 2018/6/5.
 */
@Component
public class HiRestTemplateClient {

    private Logger logger = LoggerFactory.getLogger(HiRestTemplateClient.class);

    @Autowired
    RestTemplate restTemplate;

    public String hi(String name){
        try {
            String rslt = restTemplate.getForObject("http://CLIENT-ACCESS-DB/hi?name=" + name, String.class);
            return rslt;
        } catch (Exception e) {
            logger.error("Call Error: {}", e.getMessage());
            logger.error("", e);
            return null;
        }
    }
}
