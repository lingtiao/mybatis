package com.chen.test;

import com.chen.mapper.BrandMapper;
import com.chen.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands= mapper.selectAll();
        System.out.println(brands.toString());
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {

        int id =1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand= mapper.selectById(id);
        System.out.println(brand);
        sqlSession.close();
    }
}
