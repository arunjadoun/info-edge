package com.infoedge.dao;

import com.hackerrank.github.model.Lab;
import com.hackerrank.github.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TestDao extends JpaRepository<Test, Integer>  {
    @Query(name = "select t from Test t where t.labId = ?1 order by t.endTime desc")
    public List<Test> getByLabId(Integer labId);

}
