package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CacheManager cacheManager = new CacheManager();
        CommandProcessor commandProcessor = new CommandProcessor(cacheManager);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Программа запущена. Введите команды:");

        while (true) {
            System.out.print("Введите команду: ");
            String input = scanner.nextLine();
            commandProcessor.process(input);
        }
    }
}
