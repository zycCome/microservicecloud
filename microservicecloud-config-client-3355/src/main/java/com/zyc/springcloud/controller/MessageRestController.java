package com.zyc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RefreshScope
@RestController
class MessageRestController {

    @Value("${testmsg: defaultmsg}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

}

