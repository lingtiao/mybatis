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

        int id = 2;
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

//       companyName = "%" + companyName + "%";
//       brandName = "%" +brandName +"%";


        //封装对象
       /* Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);*/

        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName",companyName);
        //map.put("brandName",brandName);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();



        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //List<Brand> brands = mapper.selectByCondition(status,brandName,companyName);
        //List<Brand> brands = mapper.selectByCondition(brand);
        List<Brand> brands = mapper.selectByCondition(map);

        System.out.println(brands.toString());
        sqlSession.close();
    }

    @Test
    public void testSelectConditionSingle() throws IOException {

        int status = 2;
        String companyName="华为";
        String brandName="华为";

        //处理参数

//       companyName = "%" + companyName + "%";
//       brandName = "%" +brandName +"%";


       //封装对象
        Brand brand = new Brand();
        //brand.setBrandName(brandName);
        //brand.setCompanyName(companyName);
        //brand.setStatus(status);



        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();



        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //List<Brand> brands = mapper.selectByCondition(status,brandName,companyName);
        List<Brand> brands = mapper.selectByConditionSingle(brand);


        System.out.println(brands.toString());
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        //开启事务
        //sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {

        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "手机中的战斗机";
        int ordered = 100;

        //封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //开启事务
        //sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {

        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description = "波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 8;

        //封装对象
        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int count = mapper.update(brand);
        System.out.println(count);


        //sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteById() throws IOException {

        int id = 7;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(id);


        //sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteByIds() throws IOException {

        int[] ids = {4,5};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);


        sqlSession.commit();

        sqlSession.close();
    }
}
