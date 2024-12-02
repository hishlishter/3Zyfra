package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CacheManagerTest {
    private CacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        // Создаем мок для CacheRepository
        CacheRepository cacheRepository = mock(CacheRepository.class);
        // Передаем мок в конструктор CacheManager
        cacheManager = new CacheManager(cacheRepository);
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
        assertEquals(null, cacheManager.getValue("3", "name"));
    }

    @Test
    public void testUpdateCache() {
        cacheManager.addToCache("4", "status", "active");
        cacheManager.updateCache("4", "inactive");
        assertEquals("inactive", cacheManager.getValue("4", "status"));
    }

    @Test
    public void testClearCache() {
        cacheManager.addToCache("5", "role", "admin");
        cacheManager.clearCache();
        assertEquals(null, cacheManager.getValue("5", "role"));
    }
}
