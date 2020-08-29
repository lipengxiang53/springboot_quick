package redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author lipengxiang
 * @Date 2020/8/18 15:30
 * @description
 */
public class RedisJava {
    public static void main(String[] args) {
        //先启动redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功!");
        System.out.println("服务正在运行: " + jedis.ping());
        System.out.println(jedis.get("runoobkey"));
        jedis.rpush("list2", "php");
        jedis.rpush("list2", "vue");
        System.out.println(jedis.lrange("list2", 0, -1));
//        jedis.ltrim("list2", 3,-1);
//        System.out.println(jedis.lrange("list2", 0, -1));

        //string
        jedis.set("string","k11str");
        System.out.println(jedis.get("string"));

        //list
        jedis.lpush("list1","l1");
        jedis.lpush("list1","l2");
        jedis.lpush("list1","l3");
        jedis.lpush("list1","l4");
        List<String> list1 = jedis.lrange("list1",0,-1);
        System.out.println(list1);

        //hash
        jedis.hset("hash1","name","lpx");
        jedis.hset("hash1","addr","nanjing");
        jedis.hset("hash1","age","18");
        Map<String,String> map = jedis.hgetAll("hash1");
        System.out.println(map);


        //set
        jedis.sadd("set2","s1");
        jedis.sadd("set2","s2","s3","s4");
        Set<String> set = jedis.smembers("set2");
        System.out.println(set);
        //zset
        jedis.zadd("sorted",10,"z1");
        jedis.zadd("sorted",20,"z2");
        Set<String> zset = jedis.zrangeByScore("sorted",0,30);
        System.out.println(zset);

//        Set<String> keys = jedis.keys("*");
//        Iterator<String> it = keys.iterator();
//
//        while (it.hasNext()) {
//            String next = it.next();
//            System.out.println(next);
//        }

    }
}
