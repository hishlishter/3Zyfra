package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Main main;

    @BeforeEach
    public void setUp() {
        main = new Main();
        main.initializeCacheWithDefaultData(); // инициализируем кэш перед каждым тестом
    }

    @Test
    public void testGetValue_ValidData() {
        String value = main.getValue("1", "name");
        assertEquals("John", value, "Должно вернуть 'John' для объекта с id=1 и propertyId='name'");
    }

    @Test
    public void testGetValue_InvalidData() {
        String value = main.getValue("999", "name");
        assertNull(value, "Должно вернуть null для несуществующего объекта");
    }

    @Test
    public void testAddToCache() {
        main.addToCache("3", "color", "blue");
        String value = main.getValue("3", "color");
        assertEquals("blue", value, "Должно вернуть 'blue' для объекта с id=3 и propertyId='color'");
    }

    @Test
    public void testUpdateCache() {
        main.updateCache("1", "updatedValue");
        String updatedValue = main.getValue("1", "name");
        assertEquals("updatedValue", updatedValue, "Значение должно быть обновлено на 'updatedValue'");
    }
}
