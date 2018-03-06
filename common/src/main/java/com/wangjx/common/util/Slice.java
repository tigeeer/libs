package com.wangjx.common.util;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2016/11/25
 * Time: 11:50
 */
public class Slice<T> {

    private List<T> list;
    private int total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
