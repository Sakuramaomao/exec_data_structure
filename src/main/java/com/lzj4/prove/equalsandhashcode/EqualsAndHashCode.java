package com.lzj4.prove.equalsandhashcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * equals和 == 的区别：
 * == 用来比较基本数据类型，还有对象是否是同一个引用。
 * equals 用来比较对象中的属性值。
 * <p>
 * equals和hashCode方法的关系：
 * 对象equals相等，hashCode必相等。反之，则不一定。
 * 上面成立的前提条件是此对象重写equals方法时必须重写hashCode方法。
 * 这点从IDE中的快捷键也能看出来，在重写是提供的工具方法是 "equals() and hashCode()"，并没有分开为两个功能。
 *
 * @Author Sakura
 * @Date 2020/2/12 10:37
 */
public class EqualsAndHashCode {
    public static void main(String[] args) {
        Student lzj1 = new Student("lzj1", 11);
        Student lzj2 = new Student("lzj1", 11);
        System.out.println(lzj1 == lzj2);
        System.out.println(lzj1.equals(lzj2));

        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(lzj1);
        studentSet.add(lzj2);
        System.out.println(studentSet.size());

        HashMap<Student, String> stuMap = new HashMap<>();
        stuMap.put(lzj1, "lzj1");
        stuMap.put(lzj2, "lzj2");
        System.out.println(stuMap.keySet().size());
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}