package com.zb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/***
 * 集合操作
 * @author once
 * @date 2020/10/22 23:21
 *
 */
@Service
public class SetService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(String key, List<Object> list) {
        redisTemplate.opsForSet().add(key, list);
    }

    public Set get(String key) {
        return redisTemplate.opsForSet().members(key);
    }

}
