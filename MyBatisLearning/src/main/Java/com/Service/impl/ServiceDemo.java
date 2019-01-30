package com.Service.impl;

import com.Service.Service;
import com.pojo.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDemo implements Service {
    @Override
    public List selAll() throws NamingException, SQLException {
        ArrayList arrayList = new ArrayList();
        Context cxt = new InitialContext();
        DataSource dataSource = (DataSource) cxt.lookup("java:comp/enc/test");
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from flower");
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next())
        {
            System.out.println("" + resultSet.getObject(1) + resultSet.getObject(2) + resultSet.getObject(3));
        }
        return null;
    }

    @Override
    public PageInfo page(int pageNum, int pageSize) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PageInfo pageInfo = new PageInfo((pageNum-1) * pageSize, pageSize);
        pageInfo.setList(sqlSession.selectList("page", pageInfo));
        int count = sqlSession.selectOne("pageCount");
        pageInfo.setPageSum(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        return pageInfo;
    }
}
