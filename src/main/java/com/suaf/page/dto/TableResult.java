package com.suaf.page.dto;

import lombok.Data;

import java.util.List;

/**
 * <br>
 *
 * @author Suaf
 * @date 2022/6/4 12:35
 * @verson
 */
@Data
public class TableResult<T> {
    /**
     * 记录
     */
    private List<T> rows;
    /**
     * 总条数
     */
    private long totalCount;
    /**
     * 总页数
     * totalCount 91
     * pageSize 10
     * ==== 10页
     */
    private long pageCount;


    /**
     * 计算总的页数，根据pageSize和totalCount
     * @param pageSize
     */
    public void setPageCount(Integer pageSize) {
        if (pageSize == 0) {
            return;
        }
        if (totalCount % pageSize == 0) {
            this.pageCount = totalCount / pageSize;
        } else {
            this.pageCount = totalCount / pageSize + 1;
        }
    }
}
