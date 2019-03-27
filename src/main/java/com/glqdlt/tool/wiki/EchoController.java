package com.glqdlt.tool.wiki;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author glqdlt
 * 2019-03-27
 */
@RestController
@RequestMapping("/")
public class EchoController {

    @Audit
    @GetMapping("greeting")
    public String replyEcho(@RequestParam(value = "message") String message, @RequestParam("count") Integer count){
        StringBuilder m = new StringBuilder();
        for(int i= 0; i < count; i++){
            m.append(message);
        }
        return "reply ~ "+m;
    }
}


