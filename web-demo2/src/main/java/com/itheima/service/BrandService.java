package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.poij.Brand;
import com.itheima.utils.SessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class BrandService {
    private SqlSessionFactory sqlSessionFactory = SessionFactoryUtils.getSqlSessionFactory();


    /**
     * 查询所有
     * @return
     */
    public ArrayList<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        ArrayList<Brand> brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    /*增加商品*/
    public void addBrand(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //设置为自动提交事务
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.addBrand(brand);
        sqlSession.close();
    }

    /*根据id查询*/
    public Brand selectByID(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    /*根据id修改数据*/
    public void updateById(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.updateById(brand);
        sqlSession.close();
    }

    /*根据id删除数据*/
    public void deleteById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteById(id);
        sqlSession.close();
    }

}
