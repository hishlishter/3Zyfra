package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CacheManager cacheManager;

    public CacheController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostMapping("/add")
    public String addToCache(@RequestParam String objectId,
                             @RequestParam String propertyId,
                             @RequestParam String value) {
        cacheManager.addToCache(objectId, propertyId, value);
        return "Added to cache";
    }

    @GetMapping("/get")
    public String getFromCache(@RequestParam String objectId,
                               @RequestParam String propertyId) {
        String value = cacheManager.getValue(objectId, propertyId);
        return value != null ? value : "Not found";
    }

    @PutMapping("/update")
    public String updateCache(@RequestParam String objectId,
                              @RequestParam String newValue) {
        cacheManager.updateCache(objectId, newValue);
        return "Cache updated";
    }

    @DeleteMapping("/clear")
    public String clearCache() {
        cacheManager.clearCache();
        return "Cache cleared";
    }

    @GetMapping("/all")
    public Map<String, Map<String, String>> getAllCache() {
        return cacheManager.getAllCache();
    }
}
