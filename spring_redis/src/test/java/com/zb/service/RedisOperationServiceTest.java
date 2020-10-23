package com.zb.service;

import com.zb.RedisApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * @author Zhang Bo
 * @date 2020/10/23 15:42
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisApplication.class)
public class RedisOperationServiceTest {

    @Autowired
    private StringService stringService;

    @Autowired
    private HashService hashService;

    @Autowired
    private ListService listService;

    @Autowired
    private SetService setService;

    @Autowired
    private SortSetService sortSetService;

    @Test
    public void stringSaveTest() {
        stringService.save("testKey","testValue");
        String val = stringService.get("testKey");
        Assert.assertEquals("error","testValue",val);
    }

    @Test
    public void hashSaveTest() {
        hashService.save("testHashKey","name","张三");
        hashService.save("testHashKey","age",18);
        Map map = hashService.get("testHashKey");
        for (Object o : map.keySet()) {
            if (o.equals("name")) {
                Assert.assertEquals("error","张三",map.get(o));
            }
            if (o.equals("age")) {
                Assert.assertEquals("error",18,map.get(o));
            }
        }
    }

    @Test
    public void listSaveTest() {
        List<Object> tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList("张三", 1, "hehe"));
        listService.save("testListKey",tempList);
        List list = listService.get("testListKey");
        for (Object o : list) {
            Assert.assertTrue(tempList.contains(o));
        }
    }

    @Test
    public void setSaveTest() {
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(Arrays.asList("张三", 1, "hehe"));
        setService.save("setTestKey",list);
        Set set = setService.get("setTestKey");
        for (Object o : set) {
            if (o instanceof List) {
                List listR = (List) o;
                for (Object term : list) {
                    Assert.assertTrue(listR.contains(term));
                }
            }
        }
    }

    @Test
    public void zSetSaveTest() {
        sortSetService.save("zSetTestKey","张三",99.1);
        sortSetService.save("zSetTestKey","李四",100);
        Set set = sortSetService.get("zSetTestKey");
        for (Object o : set) {
            Assert.assertTrue(o.equals("张三") || o.equals("李四"));
        }
    }
}
