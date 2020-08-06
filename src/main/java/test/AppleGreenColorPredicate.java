package test;

import test.Dao.Apple;

/**
 * @Author lipengxiang
 * @Date 2020/7/31 16:07
 * @description
 */

public class AppleGreenColorPredicate implements ApplePredicate{
    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }
}