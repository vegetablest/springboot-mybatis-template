package com.suaf.page.dto;

import lombok.Data;

/**
 * <br>
 *     dto的公共抽取,分页查询
 *     如果配置的和page helper中的params一样，直接会分页，就不用声明分页了
 *
 * @author Suaf
 * @date 2022/6/4 12:30
 * @verson
 */
@Data
public class BaseDto {
    /**
     * 当前查询的第几页 从1开始
     */
    private Integer startPage;
    /**
     * 每页查询 多少行
     */
    private Integer pageSize;

    /**
     * 是否count条数,为false则不需要
     */
    private boolean countSql;

    /**
     * 手写需要这个，也需要下边的set方法，使用插件的时候插件都给做了
     */
    private Integer offset;

    /**
     * limit 的 offset
     * @return
     */
    public void setOffset() {
        //不做默认处理了
        if (startPage == null || pageSize == null) {
            return;
        }
        this.offset = ((startPage < 1 ? 0 : startPage - 1) * pageSize);
    }
}
