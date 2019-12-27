package com.crown.mybatis.demo1.mapper;

import com.crown.mybatis.demo1.entity.Address;

/**
 * @ClassName AddressMapper
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:41
 * @Version 1.0
 */
public interface AddressMapper {
    Address selectByUid(Integer uid);
}
