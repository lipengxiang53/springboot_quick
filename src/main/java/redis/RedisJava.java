package redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
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
        jedis.auth("lpx");
        System.out.println("连接成功!");
        System.out.println("服务正在运行: " + jedis.ping());
        System.out.println(jedis.get("runoobkey"));
        jedis.rpush("k2", "php");
        jedis.rpush("k2", "vue");
        System.out.println(jedis.lrange("k2", 0, -1));

        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();

        while (it.hasNext()) {
            String next = it.next();
            System.out.println(next);
        }

    }
}
