package com.boot.manager;

import com.boot.cache.CacheType;
import com.boot.cache.DigestManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheResolver = "cacheResolver")
public class TestManagerImpl implements TestManager {

    private CacheType cacheType = CacheType.CONCURRENT_MAP;

    @Cacheable("test")
    @Override
    public String getValue(String key){
        System.out.println("Reading inside manager:");
        return "Test";
    }

    @Override
    public CacheType getCacheType() {
        return cacheType;
    }

    @Override
    public void setCacheType(CacheType cacheType) {
        this.cacheType = cacheType;
    }
}
