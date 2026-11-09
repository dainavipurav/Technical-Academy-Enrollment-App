package com.learning.springboot.technicalacademyenrollmentapp.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/redis")
@RestController
public class RedisTestController {

    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/save")
    public void saveDataToRedis(@RequestParam String key, @RequestParam String value){
        System.out.println("Key : " + key + " Value : " + value);
        redisTemplate.opsForValue().set("dainavi:" + key, value);
    }

    @GetMapping("/get")
    public String getDataFromRedis(@RequestParam String key){
        return redisTemplate.opsForValue().get("dainavi:" + key);
    }

    @DeleteMapping("/delete")
    public String deleteByKeyFromRedis(@RequestParam String key){
        return redisTemplate.opsForValue().getAndDelete("dainavi:" + key);
    }

//    @DeleteMapping("/delete")
//    public void deleteAllDataFromRedis(){
//        redisTemplate.opsForValue().getAndDelete("dainavi");
//    }
}
