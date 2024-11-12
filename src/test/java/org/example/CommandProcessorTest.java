package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CommandProcessorTest {
    private CommandProcessor commandProcessor;
    private CacheManager cacheManager;

    @BeforeEach
    public void setUp() {
        cacheManager = mock(CacheManager.class);
        commandProcessor = new CommandProcessor(cacheManager);
    }

    @Test
    public void testProcessAddCommand() {
        commandProcessor.process("add 1 name John");
        verify(cacheManager).addToCache("1", "name", "John");
    }

    @Test
    public void testProcessGetCommand() {
        when(cacheManager.getValue("1", "name")).thenReturn("John");
        commandProcessor.process("get 1 name");
        verify(cacheManager).getValue("1", "name");
    }

    @Test
    public void testProcessErrorCommand() {
        commandProcessor.process("ERROR");
        verify(cacheManager).clearCache();
    }

    @Test
    public void testProcessUnknownCommand() {
        commandProcessor.process("unknown command");
        // Никаких действий не происходит, просто проверяем, что метод не вызван
        verifyNoInteractions(cacheManager);
    }
}
