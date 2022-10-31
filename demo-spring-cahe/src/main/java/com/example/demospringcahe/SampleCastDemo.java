package com.example.demospringcahe;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
public class SampleCastDemo implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    static final String MUNICIPIO_CACHE = "municipio";
    static final String TRANSACTIONS_CACHE = "transactions";

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(asList(MUNICIPIO_CACHE, TRANSACTIONS_CACHE));
    }
}


