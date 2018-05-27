package com.boot.cache;

import com.boot.exception.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CacheResolver implements org.springframework.cache.interceptor.CacheResolver {
    @Autowired
    @Qualifier("noOpCacheManager")
    private CacheManager noOpCacheManager;

    @Autowired
    @Qualifier("concurrentMapCacheManager")
    private CacheManager concurrentMapCacheManager;

    @Autowired
    @Qualifier("concurrentMapCacheManager")
    private CacheManager defaultCacheManager;

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> cacheOperationInvocationContext) {
        CacheManager cacheManager;
        if (cacheOperationInvocationContext.getTarget() instanceof DigestManager) {
            DigestManager digestManager = (DigestManager) cacheOperationInvocationContext.getTarget();
            switch (digestManager.getCacheType()){
                case NO_OP:
                    cacheManager = noOpCacheManager;
                    break;
                case CONCURRENT_MAP:
                    cacheManager = concurrentMapCacheManager;
                    break;
                default:
                    throw new CacheException();
            }
        } else {
            cacheManager = defaultCacheManager;
        }
        Set<String> cacheNames = cacheOperationInvocationContext.getOperation().getCacheNames();
        return cacheNames.stream().map(e -> cacheManager.getCache(e)).collect(Collectors.toSet());
    }
}
