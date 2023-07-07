package com.projectchat.ChatServe.controller;

import com.projectchat.ChatServe.entity.Greeting;
import com.projectchat.ChatServe.entity.HelloMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Log4j2
@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings") // this is the topic that the client subscribes to
    public Greeting greet (HelloMessage message) throws Exception {
         Thread.sleep(1000); // simulated delay
        log.info("Received message: " + message.getName());
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
