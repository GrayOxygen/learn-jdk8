package com.shineoxygen.study.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 中间操作：filter，map，limit等
 * 终端操作：forEach，count
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("张明");
        names.add("张小花");
        names.add("刘得力");
        names.add("王辉真");
        names.add("王辉");
        names.add("付真");

        names.stream().filter((x) -> x.contains("辉")).map((x) -> "参赛选手：" + x).limit(2).forEach(System.out::println);
        System.out.println(names.stream().count());


        // map 映射到每个元素
        String[] hello = new String[]{
                "hello", "world"
        };
        Arrays.stream(hello).map(word -> word.split("")).collect(Collectors.toList())//
                .forEach(word -> {
                            for (String temp : word) {
                                System.out.print(temp);
                            }
                            System.out.println("====");
                            System.out.println(word.length);
                            System.out.println("====");
                        }
                );

        Arrays.stream(hello).map(word -> word.split(""))//
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
