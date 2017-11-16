package com.shineoxygen.study.test;

import com.shineoxygen.study.model.Apple;
import com.shineoxygen.study.model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InnerClassTest {
    private static List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    public static void main(String args[]) {
        //使用内部类过滤，不够简洁，模板代码太多
        List<Apple> apples = findApplesByColor(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == "green";
            }
        });
        apples.stream().forEach(System.out::println);

        apples = findApplesByColor(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == "red";
            }
        });
        apples.stream().forEach(System.out::println);

    }

    public static List<Apple> findApplesByColor(List<Apple> list, ApplePredicate applePredicate) {
        List<Apple> colorApples = new ArrayList<>();
        for (Apple temp : list) {
            if (applePredicate.test(temp)) {
                colorApples.add(temp);
            }
        }
        return colorApples;
    }

}


interface ApplePredicate {
    public abstract boolean test(Apple apple);
}
