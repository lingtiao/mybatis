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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        int id = 1;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();



        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand= mapper.selectById(id);
        System.out.println(brand);
        sqlSession.close();
    }


    @Test
    public void testSelectCondition() throws IOException {

        int status = 1;
        String companyName="华为";
        String brandName="华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" +brandName +"%";
        String resource = "mybatis-config.xml";

        //封装对象
       /* Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);*/

        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();



        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //List<Brand> brands = mapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands = mapper.selectByCondition(brand);
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands);



        sqlSession.close();
    }

}
