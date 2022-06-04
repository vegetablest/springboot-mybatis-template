package com.suaf.page;

import com.suaf.page.dao.CityMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <br>
 *
 * @author Suaf
 * @date 2022/6/4 12:17
 * @verson
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisBaseTest {

    @Autowired(required = false)
    public CityMapper cityMapper;
}
