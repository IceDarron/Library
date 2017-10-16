package com.iceDarron.data.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

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
