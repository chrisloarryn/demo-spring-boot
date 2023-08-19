package com.chrisloarryn.demospringboot.controller;

import com.chrisloarryn.demospringboot.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/message"
    )
    Message getMessage() {
        return new Message("Hello World!");
    }
}
