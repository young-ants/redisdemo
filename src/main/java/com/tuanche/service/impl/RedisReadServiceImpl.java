package com.tuanche.service.impl;

import com.tuanche.service.RedisReadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.*;

/**
 * Created by Administrator on 2017/7/12.
 */
@Service
public class RedisReadServiceImpl implements RedisReadService {

    private static final Logger log = LoggerFactory.getLogger(RedisReadServiceImpl.class);


    public String get(String key, JedisCluster jedisCluster) {
        return jedisCluster.get(key);
    }

    public Set<String> keys(String regiexKey, JedisCluster jedisCluster) {
        Set<String> set = new TreeSet<String>();
        Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();
        for (String k: clusterNodes.keySet()) {
            JedisPool jedisPool = clusterNodes.get(k);
            Jedis resource = jedisPool.getResource();
            try {
              set.addAll(resource.keys(regiexKey + "*"));
            } catch (Exception e) {
                log.error("get keys exception.please retry");
            } finally {
                resource.close();
            }
        }
        return set;
    }

    public Long pttl(String key, JedisCluster jedisCluster) {
        return jedisCluster.pttl(key);
    }

    public String randomkey(JedisCluster jedisCluster) {
        Set<String> keys = this.keys("", jedisCluster);
        if(null != keys && keys.size() > 0) {
            List list = new ArrayList(keys);
            Object o = list.get((int) Math.floor(Math.random() * keys.size()));
            return null == o ? null : String.valueOf(o) ;
        }
        return null;
    }


}
