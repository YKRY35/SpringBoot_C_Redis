package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import util.RedisUtil;

@RestController
public class C {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/set")
    public void set(@RequestParam(value="key", defaultValue = "k") String key,
                    @RequestParam(value = "value", defaultValue = "v") String value){
        redisUtil.setValue(key, value);
    }

    @RequestMapping("/get")
    public Object get(@RequestParam(value="key", defaultValue = "k") String key){
        return redisUtil.getValue(key);
    }
}
