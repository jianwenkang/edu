package com.crown.mybatis.demo1.mapper;

import com.crown.mybatis.demo1.entity.Phnoe;

import java.util.List;

/**
 * @ClassName PhoneMapper
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:41
 * @Version 1.0
 */
public interface PhoneMapper {
    List<Phnoe> selectByUid(Integer uid);
}
