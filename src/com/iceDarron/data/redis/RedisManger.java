package com.iceDarron.data.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisManger {

    private static JedisPool jedisPool = null;

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getResource() {
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
            if (jedis!=null) {
                returnResource(jedis);
            }
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}
