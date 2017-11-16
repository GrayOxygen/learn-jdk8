package com.shineoxygen.study.test;

import com.shineoxygen.study.model.Apple;
import com.shineoxygen.study.model.Pear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {
    private static List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
            new Apple(155, "green"),
            new Apple(120, "red"));

    public static void main(String args[]) {
        //使用内部类过滤，不够简洁，模板代码太多
        List<Apple> apples = findApplesByColor(inventory, (Apple apple) -> {
            return apple.getColor() == "green";
        });

        printApples(apples, (Apple apple) -> {
            System.out.println(apple);
        });

        magicPearByApple(inventory, (Apple apple) -> {
            Pear pear = new Pear();
            pear.setColor(apple.getColor());
            return pear;
        }).stream().forEach(System.out::println);

    }

    public static List<Apple> findApplesByColor(List<Apple> list, LambdaApplePredicate applePredicate) {
        List<Apple> colorApples = new ArrayList<>();
        for (Apple temp : list) {
            if (applePredicate.test(temp)) {
                colorApples.add(temp);
            }
        }
        return colorApples;
    }

    public static void printApples(List<Apple> list, LambdaAppleConsumer lambdaAppleConsumer) {
        List<Apple> colorApples = new ArrayList<>();
        for (Apple temp : list) {
            lambdaAppleConsumer.accept(temp);
        }
    }

    public static List<Pear> magicPearByApple(List<Apple> list, LambdaAppleFunction lambdaAppleFunction) {
        List<Pear> pears = new ArrayList<>();
        for (Apple temp : list) {
            Pear pear = lambdaAppleFunction.apply(temp);
            pear.setType("梨子");
            pears.add(pear);
        }
        return pears;
    }

    /**
     * 函数式接口，此处实际上就是jdk8提供的Predicate的lambda接口定义
     */
    @FunctionalInterface
    interface LambdaApplePredicate {
        //函数描述符
        boolean test(Apple apple);
    }

    /**
     * 函数式接口，此处实际上就是jdk8提供的Consumer的lambda接口定义
     */
    @FunctionalInterface
    interface LambdaAppleConsumer {
        void accept(Apple apple);
    }


    /**
     * 函数式接口，此处实际上就是jdk8提供的Function的lambda接口定义
     */
    @FunctionalInterface
    interface LambdaAppleFunction {
        Pear apply(Apple apple);
    }
}



