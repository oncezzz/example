package com.zb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/***
 * 对象操作
 * @author once
 * @date 2020/10/22 23:21
 *
 */
@Service
public class HashService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(String key,Object field,Object val) {
        redisTemplate.opsForHash().put(key, field, val);
    }

    public Map get(String key) {
        return redisTemplate.opsForHash().entries(key);
    }
}
