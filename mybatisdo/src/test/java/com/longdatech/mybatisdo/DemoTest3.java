package com.longdatech.mybatisdo;

import com.longdatech.mybatisdo.dao.SysUser;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

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



    @Test
    public void test2(){
        ObjectFactory factory = new DefaultObjectFactory();
        List<Class<?>> typeList = new ArrayList<>();
        List<Object> valueList = new ArrayList<>();

        typeList.add(Integer.class);
        typeList.add(String.class);

        valueList.add(12);
        valueList.add("liyinlong");

        Student stu = factory.create(Student.class,typeList,valueList);

        System.out.println(stu);


    }

    @Test
    public void test3() throws Exception{
        SqlSessionFactoryBuilder builder;


    }














}
