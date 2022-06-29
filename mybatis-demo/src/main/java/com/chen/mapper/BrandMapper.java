package com.chen.mapper;

import com.chen.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(int id);
}
