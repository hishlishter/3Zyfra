package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cache")
public class CacheController {
    private final CacheManager cacheManager;

    public CacheController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostMapping("/add")
    public void addToCache(@RequestParam String objectId,
                           @RequestParam String propertyId,
                           @RequestParam String value) {
        cacheManager.addToCache(objectId, propertyId, value);
    }

    @GetMapping("/get")
    public String getFromCache(@RequestParam String objectId,
                               @RequestParam String propertyId) {
        return cacheManager.getValue(objectId, propertyId);
    }

    @PostMapping("/update")
    public void updateCache(@RequestParam String objectId,
                            @RequestParam String newValue) {
        cacheManager.updateCache(objectId, newValue);
    }

    @DeleteMapping("/clear")
    public void clearCache() {
        cacheManager.clearCache();
    }

    @GetMapping("/all")
    public List<CacheEntry> getAllCache() {
        return cacheManager.getAllCache();
    }
}
