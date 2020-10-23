package com.zb.controller;

import com.zb.common.BaseException;
import com.zb.common.Response;
import com.zb.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 用户APi
 * @author once
 * @date 2020/9/12 17:35
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public Response<User> detail(@PathVariable Long id) {
        if (id == 1) {
            return Response.success(User.builder().id(id).name("张三").build());
        } else if (id == 2) {
            return Response.success(User.builder().id(id).name("李三").build());
        }
        throw new BaseException(-1, "用户不存在");
    }
}
