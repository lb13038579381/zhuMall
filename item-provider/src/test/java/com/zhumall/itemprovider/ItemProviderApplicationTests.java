package com.zhumall.itemprovider;

import com.netflix.discovery.converters.Auto;
import com.zhumall.commonutils.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemProviderApplicationTests {
@Autowired
    RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        System.out.println(redisUtil.getJedis());
    }

}
