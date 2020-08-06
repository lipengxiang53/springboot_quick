package test;

import test.Dao.Apple;

/**
 * @Author lipengxiang
 * @Date 2020/7/31 16:07
 * @description
 */

public class AppleHeavyWeightPredicate implements ApplePredicate{
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}