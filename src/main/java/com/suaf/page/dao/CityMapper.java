package com.suaf.page.dao;

import com.suaf.page.dto.city.City;
import com.suaf.page.dto.city.CityExample;
import com.suaf.page.dto.city.CityPageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    long countByExample(CityExample example);

    int deleteByExample(CityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityExample example);

    City selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    /**
     * 自己写的分页方式
     * @return
     */
    List<City> selectByPage(CityPageDto citgeDto);

    Long selectByPageCount(CityPageDto cityPageDto);

    List<City> selectByPage2(CityPageDto citgeDto);
}