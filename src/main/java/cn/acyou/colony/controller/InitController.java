package cn.acyou.colony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * @author youfang
 * @version [1.0.0, 2018-12-06 上午 10:39]
 * @since [天天健身/促销模块]
 **/
@Controller
public class InitController {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @PostConstruct
    public void init(){
        //ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        //opsForValue.set("test", "cluster test");
        //System.out.println("11"+opsForValue.get("test"));
        RedisConnection connection = redisConnectionFactory.getConnection();
        String key = "interest";
        String value = "foot ball";
        connection.set(key.getBytes(), value.getBytes());
        byte[] bytes = connection.get(key.getBytes());
        System.out.println(new String(bytes));
        System.out.println("获取完成");
        redisTemplate.opsForValue().set("name", "xx");

        try {
            redisTemplate.opsForValue().set("name", "xx");
        }catch (Exception e){
            System.out.println("first error");
        }
        String name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

}
