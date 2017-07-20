package com.tuanche.write;

import com.tuanche.BaseTest;
import com.tuanche.api.RedisApi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/7/12.
 */
public class RedisWriteTest extends BaseTest {


    @Autowired
    RedisApi redisApi;

    @Test
    public void testSet() {
        String set = redisApi.set("testDemo", "hello");

        System.out.println(set);
    }

    @Test
    public void testSetThread() {
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
                for (int i=0;i<=10000;i++) {
                    redisApi.set("cluster_thread1"+i,"value"+i);
                }
//            }
//        });
//        thread.start();

//        Thread thread1 = new Thread(new Runnable() {
//            public void run() {
                for (int i=0;i<=10000;i++) {
                    redisApi.set("cluster_thread2"+i,"value"+i);
                }
//            }
//        });
//        thread1.start();

//        Thread thread2 = new Thread(new Runnable() {
//            public void run() {
                for (int i=0;i<=10000;i++) {
                    redisApi.set("cluster_thread3"+i,"value"+i);
                }
//            }
//        });
//        thread2.start();
    }
}
