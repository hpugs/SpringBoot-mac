package com.hpugs.springboot1.action;

import com.alibaba.fastjson.JSON;
import com.hpugs.springboot1.db.Girl;
import com.hpugs.springboot1.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GirlAction {

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/findGirls", method = RequestMethod.GET)
    public String findGirls(){
        List<Girl> girls = girlService.findGirls();
        return JSON.toJSONString(girls);
    }

}
