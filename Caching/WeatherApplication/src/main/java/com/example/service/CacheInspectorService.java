package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CacheInspectorService {

    @Autowired
    CacheManager cacheManager;

    public void printCacheContent(String cacheName){
        Cache cache = cacheManager.getCache(cacheName);
        if(cache != null){
            System.out.println("Cache Content:");
            System.out.println(Objects.requireNonNull(cache.getNativeCache()).toString());
        } else{
            System.out.println("Cache Not Found with name:"+cacheName);
        }
    }
}
