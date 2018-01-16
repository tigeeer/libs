package com.wangjx.common.util;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2016/11/25
 * Time: 11:50
 */
public class Table<T> {

    private List<T> list;
    private int count;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
