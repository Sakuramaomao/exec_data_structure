package com.src.annotation;

/**
 * 标准的注释模板。
 * @Author Sakura
 * @Date 2019/2/24 18:09
 */
public class StdAnnotation {

    /**
     * 成员属性的注释。
     */
    private int size; // 容量大小

    private int age; // ...

    /**
     * 方法的注释。
     *
     * @param   size    容量大小
     */
    public void annotation(int size) {
        // size > 0
        if (size > 0) {

        }
    }
}
