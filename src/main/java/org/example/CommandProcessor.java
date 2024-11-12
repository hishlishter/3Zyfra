package org.example;

public class CommandProcessor {
    private final CacheManager cacheManager;

    public CommandProcessor(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void process(String input) {
        if (input.equalsIgnoreCase("ERROR")) {
            handleError();
            return;
        }

        String[] parts = input.split(" ");
        switch (parts[0].toLowerCase()) {
            case "get":
                if (parts.length == 3) {
                    String value = cacheManager.getValue(parts[1], parts[2]);
                    System.out.println(value != null ? value : "Значение не найдено.");
                } else {
                    System.out.println("Некорректный формат команды get.");
                }
                break;

            case "add":
                if (parts.length == 4) {
                    cacheManager.addToCache(parts[1], parts[2], parts[3]);
                } else {
                    System.out.println("Некорректный формат команды add.");
                }
                break;

            case "update":
                if (parts.length == 3) {
                    cacheManager.updateCache(parts[1], parts[2]);
                } else {
                    System.out.println("Некорректный формат команды update.");
                }
                break;

            default:
                System.out.println("Неизвестная команда.");
        }
    }

    private void handleError() {
        cacheManager.clearCache();
        TimerTask.startTimer(() -> System.out.println("Кэш успешно очищен."), 30);
    }
}
