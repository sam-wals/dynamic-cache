package com.boot.controller;

import com.boot.cache.CacheType;
import com.boot.manager.TestManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TestManager testManager;

    @RequestMapping("/")
    public String getValue(){
        return testManager.getValue("key");
    }

    @RequestMapping(value = "/modify/{cacheType}", method = RequestMethod.PUT)
    public void modifyCachingStrategy(@PathVariable("cacheType") CacheType cacheType){
        testManager.setCacheType(cacheType);
    }
}
