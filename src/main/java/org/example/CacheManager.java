package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheManager {
    private final Map<String, Map<String, String>> cache = new HashMap<>();

    public void addToCache(String objectId, String propertyId, String value) {
        cache.computeIfAbsent(objectId, k -> new HashMap<>()).put(propertyId, value);
        System.out.println("Данные добавлены в кэш: [" + objectId + ", " + propertyId + "]");
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
            System.out.println("Кэш обновлен для объекта " + objectId);
        } else {
            System.out.println("Объект " + objectId + " не найден в кэше.");
        }
    }

    public void clearCache() {
        cache.clear();
        System.out.println("Кэш очищается...");
    }

    // Новый метод
    public List<CacheEntry> getAllCache() {
        List<CacheEntry> cacheEntries = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> objectEntry : cache.entrySet()) {
            String objectId = objectEntry.getKey();
            Map<String, String> properties = objectEntry.getValue();
            for (Map.Entry<String, String> propertyEntry : properties.entrySet()) {
                cacheEntries.add(new CacheEntry(objectId, propertyEntry.getKey(), propertyEntry.getValue()));
            }
        }
        return cacheEntries;
    }
}
