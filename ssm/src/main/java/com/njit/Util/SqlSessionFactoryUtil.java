package com.njit.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getSqlSessionFactoryInstance(){
        if(sqlSessionFactory==null){
            try {
                InputStream inputStream= Resources.getResourceAsStream("sqlMapConfig.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
}
