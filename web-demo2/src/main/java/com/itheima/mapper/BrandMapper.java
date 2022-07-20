package com.itheima.mapper;

import com.itheima.poij.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface BrandMapper {

    /*查询所有*/
    @Select("select * from tb_brand")
    ArrayList<Brand> selectAll();

    /*新增数据*/
    @Insert("insert into tb_brand values (#{id}, #{name}, #{description}, #{status})")
    void addBrand(Brand brand);

    @Select("select * from  tb_brand where id=#{id}")
    Brand selectById(Integer id);

    @Update("update tb_brand set name=#{name}, description=#{description}, status=#{status} where id=#{id}")
    void updateById(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(Integer id);
}
