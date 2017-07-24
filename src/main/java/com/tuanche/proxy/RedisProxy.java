package com.tuanche.proxy;

import com.tuanche.api.RedisApi;
import com.tuanche.service.RedisReadService;
import com.tuanche.service.RedisWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/12.
 */
@Component
public class RedisProxy implements RedisApi {

    @Autowired
    private JedisCluster jedisCluster;

    @Autowired
    private RedisWriteService redisWriteService;

    @Autowired
    private RedisReadService redisReadService;

    public String del(String key) {
        return redisWriteService.del(key,jedisCluster);
    }

    public Long clear(String key) {
        return redisWriteService.clear(key,jedisCluster);
    }

    public String set(String key, String value) {
        return redisWriteService.set(key,value,jedisCluster);
    }

    public Boolean exist(String key) {
        return redisWriteService.exist(key,jedisCluster);
    }

    public Long expire(String key,int seconds) {
        return redisWriteService.expire(key,seconds,jedisCluster);
    }

    public Long expireAt(String key,long unixTime) {
        return redisWriteService.expireAt(key,unixTime,jedisCluster);
    }

    public Set<String> keys(String regiexKey) {
        return redisReadService.keys(regiexKey,jedisCluster);
    }

    public Long persist(String key) {
        return redisWriteService.persist(key,jedisCluster);
    }

    public Long pexpire(String key,long milliseconds) {
        return redisWriteService.pexpire(key,milliseconds,jedisCluster);
    }

    public Long pexpireAt(String key,long unixTime) {
        return redisWriteService.pexpireAt(key,unixTime,jedisCluster);
    }

    public Long pttl(String key) {
        return redisReadService.pttl(key,jedisCluster);
    }

    public String randomkey() {
        return redisReadService.randomkey(jedisCluster);
    }

    public String rename(String oldKey, String newKey) {
        return redisWriteService.rename(oldKey,newKey,jedisCluster);
    }

    public Long renamenx(String oldKey, String newKey) {
        return redisWriteService.renamenx(oldKey,newKey,jedisCluster);
    }


    public String get(String key) {
        return redisReadService.get(key,jedisCluster);
    }
}
