package com.hpugs.springboot1.dao;

import com.hpugs.springboot1.db.Girl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface GirlDaoJpa extends JpaRepository<Girl, Integer> {

    List<Girl> getGirlsByName(final String name);

    @Query("select g from Girl g where g.name = ?1")
    List<Girl> findGirlsByName(String name);

//    @Query("select g from Girl g where g.name = :name")
//    List<Girl> findGirlsByName(@Param("name") String name);

//    @Query(value = "select * from girl g where g.name like %:name%", nativeQuery = true)
//    List<Girl> findGirlsByName(@Param("name") String name);

    @Override
    Page<Girl> findAll(@PageableDefault(page = 1, size = 20, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable);
}
