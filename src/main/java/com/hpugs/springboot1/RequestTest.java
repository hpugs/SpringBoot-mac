package com.hpugs.springboot1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
//@ResponseBody
//@RequestMapping(value = "/test")
public class RequestTest {

    /**
     * 不对请求方式限制
     * @return
     */
    @RequestMapping(value = "/req")
    public String req(){
        return "success";
    }

    /**
     * 限制请求方式为GET
     * @return
     */
    @RequestMapping(value = "/req1", method = RequestMethod.GET)
    public String req1(){
        return "success";
    }

    /**
     * 限制请求方式为POST
     * @return
     */
    @RequestMapping(value = "/req2", method = RequestMethod.POST)
    public String req2(){
        return "success";
    }

    //注入配置文件中的参数
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    @RequestMapping(value = "/req3", method = RequestMethod.GET)
    public String req3(){
        return "name=" + name;
    }

    @RequestMapping(value = "/req4", method = RequestMethod.GET)
    public String req4(){
        return "age=" + age;
    }

    @RequestMapping(value = "/req5", method = RequestMethod.GET)
    public String req5(){
        return "content=" + content;
    }

    //注入对象
    @Autowired
    private UserInfo userInfo;

    @RequestMapping(value = "/req6", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
    public String req6(){
        return "name=" + userInfo.getNames();
    }

    @RequestMapping(value = "/req7", method = RequestMethod.GET)
    public String req7(){
        return "age=" + userInfo.getAge();
    }

    @RequestMapping(value = "/req8", method = RequestMethod.GET)
    public String req8(){
        return "content=" + userInfo.getContent();
    }

}
