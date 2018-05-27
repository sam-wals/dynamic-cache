package com.boot.manager;

import com.boot.cache.DigestManager;

public interface TestManager extends DigestManager {
    String getValue(String key);
}
