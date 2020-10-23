package com.zb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/***
 * 字符操作
 * @author once
 * @date 2020/10/22 23:21
 *
 */
@Service
public class StringService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key,value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
