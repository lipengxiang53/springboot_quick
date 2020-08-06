package test;

import test.Dao.Apple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author lipengxiang
 * @Date 2020/7/31 16:03
 * @description
 */
public class FilteringApples {
    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(134, "green"),
                new Apple(333, "green"),
                new Apple(222, "green"),
                new Apple(120, "red"));
        List<Apple> heavyApples =
                filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples =
                filterApples(inventory, new AppleGreenColorPredicate());

        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        List<Apple> weightList = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 120;
            }
        });

        //lambda
        List<Apple> lam = filterApples(inventory, apple ->"red".equals(apple.getColor()));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,3542,32,234,53,12,5214);
        List<Integer> evenNumbers =
                filter(numbers, (Integer i) -> i % 2 == 0);
        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(numbers);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);

//        inventory.sort((Apple a1,Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
//        System.out.println(inventory);

        Thread t = new Thread(() -> System.out.println(Thread.currentThread() + "   Hello world"));

        Map<String, List<Apple>> map = inventory.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(map);


    }

    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println(result);
        return result;
    }

    //抽象化
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        System.out.println(result);

        return result;
    }


}