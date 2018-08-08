package com.dfx.data.Controller;

import com.dfx.data.Config.ServiceConfig;
import com.dfx.data.client.HiRestTemplateClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by a123456 on 2018/7/23.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private HiRestTemplateClient hiRestTemplateClient;
    @Autowired
    private ServiceConfig serviceConfig;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String index(){
        String rslt = "Port: " + serviceConfig.getPort();
        logger.info(rslt);
        return rslt;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    private String hi(@RequestParam(value = "name") String name){
        logger.info("Hi, {}", name);
        String rslt = hiRestTemplateClient.hi(name);
        logger.info("Hi, [{}]", rslt);
        return rslt;
    }
}
