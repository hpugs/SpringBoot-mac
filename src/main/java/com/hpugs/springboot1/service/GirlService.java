package com.hpugs.springboot1.service;

import com.hpugs.springboot1.dao.GirlDao;
import com.hpugs.springboot1.db.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlDao girlDao;

    public List<Girl> findGirls(){
        List<Girl> girls = girlDao.findGirls();
        return girls;
    }

}
