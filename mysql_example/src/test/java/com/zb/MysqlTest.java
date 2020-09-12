package com.zb;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.zb.domain.User;
import com.zb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 * mysql 测试
 * @author once
 * @date 2020/9/5 12:24
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {

    @Autowired
    private UserService userService;



    @Test
    public void idInsertTest() {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        TimeInterval interval = DateUtil.timer();
        interval.restart();
        Console.log("数据预热开始>>>>>>>>>>>>>>");
        for (int i = 0; i < 1000; i++) {
            User user = buildUser();
            userService.insertAutoUser(user);
            user = buildUser().setStrId(IdUtil.fastSimpleUUID());
            userService.insertUuidUser(user);
            user = buildUser().setStrId(IdUtil.objectId());
            userService.insertObjectUser(user);
            user = buildUser().setId(snowflake.nextId());
            userService.insertSnowUser(user);
        }
        Console.log("数据预热结束>>>>>>>>>>>>>>");
        Console.log("耗时:{}秒",interval.intervalSecond());

//        interval.restart();
//        Console.log("自增插入开始>>>>>>>>>>>>>>");
//        for (int i = 0; i < 500000; i++) {
//            userService.insertAutoUser(buildUser());
//        }
//        Console.log("自增插入结束>>>>>>>>>>>>>>");
//        Console.log("耗时:{}秒",interval.intervalSecond());
//
//        interval.restart();
//        Console.log("UUID插入开始>>>>>>>>>>>>>>");
//        for (int i = 0; i < 500000; i++) {
//            userService.insertUuidUser(buildUser().setStrId(IdUtil.simpleUUID()));
//        }
//        Console.log("UUID插入结束>>>>>>>>>>>>>>");
//        Console.log("耗时:{}秒",interval.intervalSecond());
//
//        interval.restart();
//        Console.log("ObjectId插入开始>>>>>>>>>>>>>>");
//        for (int i = 0; i < 500000; i++) {
//            userService.insertObjectUser(buildUser().setStrId(IdUtil.objectId()));
//        }
//        Console.log("ObjectId插入结束>>>>>>>>>>>>>>");
//        Console.log("耗时:{}秒",interval.intervalSecond());
//
//        interval.restart();
//        Console.log("snowId插入开始>>>>>>>>>>>>>>");
//        for (int i = 0; i < 500000; i++) {
//            userService.insertSnowUser(buildUser().setId(snowflake.nextId()));
//        }
//        Console.log("snowId插入结束>>>>>>>>>>>>>>");
//        Console.log("耗时:{}秒",interval.intervalSecond());

    }

    private User buildUser() {
        return new User().setName(randomName()).setMobile(randomMobile()).setAddress(randomAddress());
    }



    private String[] names = {"张三", "李四", "王麻子", "欧阳峰", "西门吹雪", "bob", "trump"};
    private String[] mobile = {"173244584579", "123244584319", "111324484579", "153204234579", "1734344584579", "173249584579", "173244584579"};
    private String[] address = {"湖北省武汉市东西湖区", "北京市西城区", "纽约华盛顿特区", "广东省深圳市罗湖区"};


    private String randomAddress() {
        return address[RandomUtil.randomInt(address.length)];
    }

    private String randomMobile() {
        return mobile[RandomUtil.randomInt(mobile.length)];
    }

    private String randomName() {
        return names[RandomUtil.randomInt(names.length)];
    }

}
