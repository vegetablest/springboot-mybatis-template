package com.suaf.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suaf.page.dto.TableResult;
import com.suaf.page.dto.city.City;
import com.suaf.page.dto.city.CityExample;
import com.suaf.page.dto.city.CityPageDto;
import org.junit.Test;

import java.util.List;

/**
 * <br>
 *
 * @author Suaf
 * @date 2022/6/4 15:16
 * @verson
 */
public class MybatisPageHelperTest extends MybatisBaseTest {
    /**
     * not page select
     */
    @Test
    public void testA() {
        CityExample cityExample = new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        criteria.andIdGreaterThan(1).andIdLessThan(100);
        List<City> cities = cityMapper.selectByExample(cityExample);
        System.out.println(cities);
    }

    /**
     * 手写分页
     */
    @Test
    public void testB() {
        CityPageDto cityPageDto = new CityPageDto();
        cityPageDto.setStartPage(3);
        cityPageDto.setPageSize(10);
        cityPageDto.setName("E");
        cityPageDto.setOffset();

        List<City> cities = cityMapper.selectByPage(cityPageDto);
        Long aLong = cityMapper.selectByPageCount(cityPageDto);

        TableResult<City> cityTableResult = new TableResult<>();
        cityTableResult.setRows(cities);
        cityTableResult.setTotalCount(aLong);
        cityTableResult.setPageCount(cityPageDto.getPageSize());

        System.out.println(cityTableResult.getPageCount());
        System.out.println(cityTableResult.getTotalCount());
        System.out.println(cityTableResult.getRows());
    }

    /**
     * page help 插件
     */
    @Test
    public void testC() {
        CityExample cityExample = new CityExample();
        CityExample.Criteria criteria = cityExample.createCriteria();
        criteria.andNameLike("%E%");
        PageHelper.startPage(3,10);
        List<City> cities = cityMapper.selectByExample(cityExample);
        PageInfo<City> cityPageInfo = PageInfo.of(cities);
        System.out.println(cityPageInfo.getPages());
        System.out.println(cityPageInfo.getTotal());
        System.out.println(cityPageInfo.getList());
    }
    /**
     * page help 插件，配置类方式，并且指定params方式
     */
    @Test
    public void testD() {
        CityPageDto cityPageDto = new CityPageDto();
        cityPageDto.setStartPage(3);
        cityPageDto.setPageSize(10);
        cityPageDto.setCountSql(true);
        cityPageDto.setName("E");

        PageHelper.startPage(cityPageDto);

        List<City> cities = cityMapper.selectByPage2(cityPageDto);
        PageInfo<City> pageInfo = new PageInfo<>(cities);
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getList());
    }
}
