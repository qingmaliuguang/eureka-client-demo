package com.dfx.data.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by a123456 on 2018/7/31.
 */
@Component
public class ServiceConfig {
    @Value("${server.port}")
    private String port;

    public String getPort() {
        return port;
    }
}
