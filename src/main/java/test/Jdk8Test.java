package test;

import test.Dao.Apple;
import test.Dao.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author lipengxiang
 * @Date 2020/6/22 15:20
 * @description
 */
public class Jdk8Test {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> tmp = new ArrayList<>();
//        //[Apple{color='green', weight=80}, Apple{color='green', weight=155}, Apple{color='red', weight=120}]
        System.out.println(inventory);
//
//        inventory = inventory.stream().filter(Apple :: isGreenApple).collect(toList());
//        //[Apple{color='green', weight=80}, Apple{color='green', weight=155}]
//        System.out.println(inventory);
//
//        inventory.removeIf(apple -> apple.getWeight() == 80);
//        //[Apple{color='green', weight=155}]
//        System.out.println(inventory);


        tmp = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println(tmp);
        System.out.println(inventory);

        tmp = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
        System.out.println(tmp);


    }
}
