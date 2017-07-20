package com.tuanche.api;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface RedisApi {

    String del(final String key);

    Long clear(final String key);

    String set(final String key,final String value);

    Boolean exist(final String key);

    Long expire(final String key,final int seconds);

    Long expireAt(final String key,final long unixTime);

    Set<String> keys(final String regiexKey);

    String persist(final String key);//PERSIST

    Long pexpire(final String key);

    Long pexpireAt(final String key);

    Long pttl(final String key);

    String randomkey(final String key);

    String rename(final String srcKey,final String desKey);

    String renamenx(final String oldKey,final String newKey);










    /***************************************************************/
    String get(final String key);
}
