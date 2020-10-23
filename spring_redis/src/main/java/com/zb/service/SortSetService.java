package com.zb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/***
 * 有序集合操作
 * @author once
 * @date 2020/10/22 23:21
 *
 */
@Service
public class SortSetService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(String key,Object value,double source) {
        redisTemplate.opsForZSet().add(key, value, source);
    }

    public Set get(String key) {
        return redisTemplate.opsForZSet().range(key, 0, -1);
    }
}
