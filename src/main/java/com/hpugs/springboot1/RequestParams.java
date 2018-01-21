package com.hpugs.springboot1;

import org.springframework.web.bind.annotation.*;

@RestController
public class RequestParams {

    @RequestMapping(value = "/par1", method = RequestMethod.GET)
    public String reqPar1(@RequestParam("name") String name){
        return name;
    }

    @RequestMapping(value = "/par2", method = RequestMethod.GET)
    public String reqPar2(@RequestParam(value = "name", required = false) String name){
        if(null != name){
            return name;
        }else{
            return "未传入参数";
        }
    }

    @RequestMapping(value = "/par3", method = RequestMethod.GET)
    public String reqPar3(@RequestParam(value = "name", defaultValue = "null") String name){
        return name;
    }

    @RequestMapping(value = "/par4/{id}", method = RequestMethod.GET)
    public Integer reqPar4(@PathVariable("id") Integer id){
        return id;
    }

    @RequestMapping(value = "/{id}/par5", method = RequestMethod.GET)
    public Integer reqPar5(@PathVariable("id") Integer id){
        return id;
    }

}
