package com.tuanche.service;

import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface RedisReadService {

    String get(final String key, final JedisCluster jedisCluster);

    Set<String> keys(final String regiexKey, final JedisCluster jedisCluster);
}
