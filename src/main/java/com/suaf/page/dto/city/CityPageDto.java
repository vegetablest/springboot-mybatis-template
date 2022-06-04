package com.suaf.page.dto.city;

import com.suaf.page.dto.BaseDto;
import lombok.Data;

/**
 * <br>
 *
 * @author Suaf
 * @date 2022/6/4 12:34
 * @verson
 */
@Data
public class CityPageDto extends BaseDto {

    /**
     * 分页查询需要的条件查询都写到这里
     */
    private String name;
}
