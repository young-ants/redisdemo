package com.tuanche.service;

import redis.clients.jedis.JedisCluster;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface RedisWriteService {

    String set(final String key, final String value, final JedisCluster jedisCluster);

    Long clear(final String key, final JedisCluster jedisCluster);

    String del(final String key, final JedisCluster jedisCluster);

    Boolean exist(final String key, final JedisCluster jedisCluster);

    Long expire(final String key,final int seconds, final JedisCluster jedisCluster);

    Long expireAt(final String key, final long unixTime,final JedisCluster jedisCluster);

    Long persist(final String key, final JedisCluster jedisCluster);

    Long pexpire(final String key, final long milliseconds, final JedisCluster jedisCluster);

    Long pexpireAt(final String key, final long unixTime, final JedisCluster jedisCluster);

    String rename(final String oldKey, final String newKey, final JedisCluster jedisCluster);

    Long renamenx(final String oldKey, final String newKey, final JedisCluster jedisCluster);
}
