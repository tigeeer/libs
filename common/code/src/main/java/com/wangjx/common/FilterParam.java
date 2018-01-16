package com.wangjx.common;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/11/1
 * Time: 14:12
 */
public class FilterParam {

    private String keyword;
    private Integer offset = 0;
    private Integer size = 200;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
