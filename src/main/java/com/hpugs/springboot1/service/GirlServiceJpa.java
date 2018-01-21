package com.hpugs.springboot1.service;

import com.hpugs.springboot1.dao.GirlDaoJpa;
import com.hpugs.springboot1.dao.MyPageable;
import com.hpugs.springboot1.db.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlServiceJpa {

    @Autowired
    private GirlDaoJpa girlDaoJpa;

    public Girl saveGirl(Girl girl){
        return  girlDaoJpa.save(girl);
    }

    public List<Girl> getGirlsByName(String name){
        return girlDaoJpa.getGirlsByName(name);
    }

    public List<Girl> findGirlsByName(String name){
        return girlDaoJpa.findGirlsByName(name);
    }

    public List<Girl> findGirls(){
        return girlDaoJpa.findAll();
    }

    public List<Girl> findGirlsByPage(Integer stateIndex, Integer maxNum){
        MyPageable myPageable = new MyPageable();
        myPageable.setPageNumber(stateIndex);
        myPageable.setPageSize(maxNum);
        myPageable.setSort(new Sort(Sort.Direction.DESC, new String[]{"id"}));
        return girlDaoJpa.findAll(myPageable).getContent();
    }


}
