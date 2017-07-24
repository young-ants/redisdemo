package com.tuanche.api;

import java.util.Set;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface RedisApi {

    /**
     * 删除给定的一个 key
     * @param key
     * @return
     */
    String del(final String key);

    /**
     * 模糊删除多个key
     * @param key
     * @return
     */
    Long clear(final String key);

    /**
     * 将字符串值 value 关联到 key
     * @param key
     * @param value
     * @return
     */
    String set(final String key,final String value);

    /**
     * 检查给定 key 是否存在
     * @param key
     * @return
     */
    Boolean exist(final String key);

    /**
     * 为给定 key 设置生存时间，当 key 过期时 (生存时间为 0 )，它会被自动删除。
     * @param key
     * @param seconds 单位：s
     * @return
     */
    Long expire(final String key,final int seconds);

    /**
     * 这个命令和EXPIREAT 命令类似，但它以毫秒为单位设置 key 的过期 unix 时间戳
     * @param key
     * @param unixTime unix的时间戳
     * @return
     */
    Long expireAt(final String key,final long unixTime);

    /**
     * 查找所有符合给定模式 pattern 的 key
     * @param regiexKey
     * @return
     */
    Set<String> keys(final String regiexKey);

    /**
     * 移除给定 key 的生存时间，将这个 key 从『易失的』(带生存时间 key ) 转换成『持久的』(一个不带生存时间、永不过期的 key )
     * @param key
     * @return
     */
    Long persist(final String key);//PERSIST

    /**
     * 以毫秒为单位设置 key 的生存时间
     * @param key
     * @param milliseconds 毫秒
     * @return
     */
    Long pexpire(final String key,final long milliseconds);

    /**
     * 以毫秒为单位设置 key 的过期 unix 时间戳
     * @param key
     * @param unixTime
     * @return
     */
    Long pexpireAt(final String key,final long unixTime);

    /**
     * 以毫秒为单位返回 key 的剩余生存时间
     * @param key
     * @return
     */
    Long pttl(final String key);

    /**
     * 从当前数据库中随机返回 (不删除) 一个 key
     * @return
     */
    String randomkey();

    /**
     * 将 key 改名为 newkey 。
     * 当 key 和 newkey 相同，或者 key 不存在时，返回一个错误
     * @param oldKey 原来key
     * @param newKey 新key
     * @return "OK" == success
     */
    String rename(final String oldKey,final String newKey);

    /**
     * 当且仅当 newkey 不存在时，将 key 改名为 newkey 。
     * @param oldKey
     * @param newKey
     * @return
     */
    Long renamenx(final String oldKey,final String newKey);










    /***************************************************************/
    String get(final String key);
}
