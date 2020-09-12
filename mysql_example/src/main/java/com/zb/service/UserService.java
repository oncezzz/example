package com.zb.service;

import com.zb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/***
 *
 * @author once
 * @date 2020/9/5 12:57
 *
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertAutoUser(User user) {
        String sql = "insert into auto_user(name,mobile,address) values(?,?,?)";
        jdbcTemplate.update(sql, user.getName(), user.getMobile(), user.getAddress());
    }

    public void insertUuidUser(User user) {
        String sql = "insert into uuid_user(id,name,mobile,address) values(?,?,?,?)";
        jdbcTemplate.update(sql,user.getStrId(),user.getName(), user.getMobile(), user.getAddress());
    }

    public void insertSnowUser(User user) {
        String sql = "insert into snow_user(id,name,mobile,address) values(?,?,?,?)";
        jdbcTemplate.update(sql, user.getId(),user.getName(), user.getMobile(), user.getAddress());
    }

    public void insertObjectUser(User user) {
        String sql = "insert into object_user(id,name,mobile,address) values(?,?,?,?)";
        jdbcTemplate.update(sql, user.getStrId(),user.getName(), user.getMobile(), user.getAddress());
    }
}
