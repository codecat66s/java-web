package com.itheima.service;

import com.itheima.mapper.UserMapper;
import com.itheima.poij.User;
import com.itheima.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*用户登录*/
    public User login(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User loginUser = mapper.login(user);
        sqlSession.close();
        return loginUser;
    }

    /*根据用户名查找用户*/
    public User selectByName(String userName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userTemp = mapper.selectByName(userName);
        sqlSession.close();
        return userTemp;
    }

    /*新增用户*/
    public void addUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(user);
        sqlSession.close();
    }

}
