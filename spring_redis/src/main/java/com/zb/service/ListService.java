package com.zb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 列表操作
 * @author once
 * @date 2020/10/22 23:21
 *
 */
@Service
public class ListService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void save(String key, List<Object> list) {
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    public List get(String key) {
        return redisTemplate.opsForList().range(key,0,-1);
    }

}
