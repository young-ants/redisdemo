package com.tuanche.service.impl;

import com.tuanche.service.RedisWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
public class RedisWriteServiceImpl implements RedisWriteService {

    private static final Logger log = LoggerFactory.getLogger(RedisWriteServiceImpl.class);

    public String set(String key, String value, JedisCluster jedisCluster) {
        return jedisCluster.set(key, value);
    }

    public Long clear(String key, JedisCluster jedisCluster) {
        Set<String> set = new TreeSet<String>();
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        for (String k : clusterNodes.keySet()) {
            JedisPool jedisPool = clusterNodes.get(k);
            Jedis resource = jedisPool.getResource();
            try {
                set.addAll(resource.keys(key + "*"));
            } catch (Exception e) {
                log.error("get keys exception,maybe add set exception,exception={}",e);
            } finally {
                resource.close();
            }
        }
        if(null != set && set.size() > 0) {
            Long count = 0L;
            for (String keys : set) {
                count += jedisCluster.del(keys);
            }
            return count;
        }
        return 0L;
    }

    public String del(String key, JedisCluster jedisCluster) {
        jedisCluster.del(key);
        return "OK";
    }

    public Boolean exist(String key, JedisCluster jedisCluster) {
        return jedisCluster.exists(key);
    }

    public Long expire(String key,int seconds, JedisCluster jedisCluster) {
        return jedisCluster.expire(key,seconds);
    }

    public Long expireAt(String key, long unixTime, JedisCluster jedisCluster) {
        return jedisCluster.expireAt(key,unixTime);
    }
}
