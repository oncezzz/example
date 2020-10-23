package com.zb.config;

import org.springframework.context.annotation.Configuration;

/***
 * redis 配置
 * @author once
 * @date 2020/10/22 23:33
 *
 */
@Configuration
public class RedisConfiguration {

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("server", 6379);
//        return new JedisConnectionFactory(config);
//    }
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate() {
//        return new StringRedisTemplate(redisConnectionFactory());
//    }
//
//    @Bean
//    public RedisTemplate redisTemplate() {
//        RedisTemplate template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory());
//        template.opsForList();
//        return template;
//    }

}
