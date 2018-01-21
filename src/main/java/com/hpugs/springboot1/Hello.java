package com.hpugs.springboot1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){
        return "hello springboot!";
    }

}
