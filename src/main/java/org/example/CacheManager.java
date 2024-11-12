package org.example;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CacheManager {
    private final Map<String, Map<String, String>> cache = new HashMap<>();

    public void addToCache(String objectId, String propertyId, String value) {
        cache.computeIfAbsent(objectId, k -> new HashMap<>()).put(propertyId, value);
    }

    public String getValue(String objectId, String propertyId) {
        Map<String, String> properties = cache.get(objectId);
        return properties != null ? properties.get(propertyId) : null;
    }

    public void updateCache(String objectId, String newValue) {
        Map<String, String> properties = cache.get(objectId);
        if (properties != null) {
            for (String key : properties.keySet()) {
                properties.put(key, newValue);
            }
        }
    }

    public void clearCache() {
        cache.clear();
    }

    public Map<String, Map<String, String>> getAllCache() {
        return cache;
    }
}
