package com.longdatech.mybatisdo;

import com.longdatech.mybatisdo.dao.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileReader;
import java.io.Reader;

public class DemoTest3 {

    @Test
    public void test1() throws Exception{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        Reader reader = new FileReader("E:\\spring\\springbootdo\\mybatisdo\\src\\main\\resources\\mybatis_config.xml");

        SqlSessionFactory factory = builder.build(reader,"pro");

        System.out.println(factory);
        factory.openSession();
        SqlSession session = factory.openSession();
        SysUser sysUser = session.getMapper(SysUser.class);
        int num = sysUser.countAll();
        System.out.println(num);

    }















}
