package com.bowo.pojo;

import java.util.Vector;

/**
 * @author zhaojufeng
 * @date 2020/8/28 9:39
 */
public class Serie {
    private static final long serialVersionUID = 1L;
    private String name;// 名字
    private Vector<Object> data;// 数据值ֵ

    public Serie() {

    }

    /**
     *
     * @param name
     *            名称（线条名称）
     * @param data
     *            数据（线条上的所有数据值）
     */
    public Serie(String name, Vector<Object> data) {

        this.name = name;
        this.data = data;
    }

    /**
     *
     * @param name
     *            名称（线条名称）
     * @param array
     *            数据（线条上的所有数据值）
     */
    public Serie(String name, Object[] array) {
        this.name = name;
        if (array != null) {
            data = new Vector<Object>(array.length);
            for (int i = 0; i < array.length; i++) {
                data.add(array[i]);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<Object> getData() {
        return data;
    }

    public void setData(Vector<Object> data) {
        this.data = data;
    }
}
