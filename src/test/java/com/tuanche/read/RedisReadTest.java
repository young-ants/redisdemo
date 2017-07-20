package com.tuanche.read;

import com.tuanche.BaseTest;
import com.tuanche.api.RedisApi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/7/12.
 */
public class RedisReadTest extends BaseTest {

    @Autowired
    RedisApi redisApi;


    @Test
    public void testGet() {
        String testDemo = redisApi.get("testDemo");
        System.out.println(testDemo);
    }

    @Test
    public void testGetThread() {
                for (int i=0;i<=10000;i++) {
                    String s = redisApi.get("cluster_thread1" + i);
                    System.out.println("thread1-----------" + s);
                }




                for (int i=0;i<=10000;i++) {
                    String s = redisApi.get("cluster_thread2" + i);
                    System.out.println("thread2-----------" + s);
                }




                for (int i=0;i<=10000;i++) {
                    String s = redisApi.get("cluster_thread3" + i);
                    System.out.println("thread3-----------" + s);
                }

    }

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("192.168.222.132",7001);

        String testDemo = jedis.get("testDemo");

        System.out.println(testDemo);
    }
}
