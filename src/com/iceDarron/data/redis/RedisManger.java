package com.iceDarron.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author IceDarron
 * @Description [redis管理类，对于缓存机制如下：
 *              1.查询 先查询缓存，命中则返回数据，未命中则去数据库查询并添加到缓存中
 *              2.更新 先更新缓存，再更新数据库
 *              3.删除 先删除缓存，再删除数据库
 *              4.新增 先增加缓存，再增加数据库]
 * @since 20171018
 */
@Repository
public class RedisManger {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 获取Jedis实例
     *
     * @return
     */
    public synchronized Jedis getResource() {
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            if (jedis != null) {
                returnResource(jedis);
            }
            e.printStackTrace();
        }
        return jedis;
    }

    /**
     * 释放jedis资源
     *
     * @param jedis
     */
    public void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}
