package com.crown.mybatis.mapper;

import com.crown.mybatis.entity.NewTest;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Crown on 2019/2/20.
 */
public interface TestDao {
    List<Map<String,Object>> selectAll();

    List<NewTest> selectTest();

    int insertMap(@Param("params")Map<String,String> map);

    int insertRunData(@Param("dsid") Integer dsid,
                      @Param("datas")Map<Integer,Double> map,//@Param("")Integer scid,@Param("")double data,
                      @Param("date")Date date,@Param("hour")Integer hour, @Param("minu")Integer minu);
}