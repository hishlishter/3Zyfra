package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CacheManagerTest {
    private CacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        cacheManager = new CacheManager();
    }

    @Test
    public void testAddToCache() {
        cacheManager.addToCache("1", "name", "John");
        assertEquals("John", cacheManager.getValue("1", "name"));
    }

    @Test
    public void testGetValue_ValidData() {
        cacheManager.addToCache("2", "age", "30");
        assertEquals("30", cacheManager.getValue("2", "age"));
    }

    @Test
    public void testGetValue_InvalidData() {
        assertNull(cacheManager.getValue("999", "name"));
    }

    @Test
    public void testUpdateCache() {
        cacheManager.addToCache("1", "name", "John");
        cacheManager.updateCache("1", "UpdatedName");
        assertEquals("UpdatedName", cacheManager.getValue("1", "name"));
    }

    @Test
    public void testClearCache() {
        cacheManager.addToCache("1", "name", "John");
        cacheManager.clearCache();
        assertNull(cacheManager.getValue("1", "name"));
    }
}
