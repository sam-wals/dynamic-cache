package com.boot;

import com.boot.cache.CacheResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {
        "com/boot/controller", "com/boot/repository", "com/boot/manager"
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Primary
    public CacheManager concurrentMapCacheManager(){
        return new ConcurrentMapCacheManager();
    }

    @Bean
    public CacheManager noOpCacheManager(){
        return new NoOpCacheManager();
    }

    @Bean
    public CacheResolver cacheResolver(){
        return new CacheResolver();
    }
}
