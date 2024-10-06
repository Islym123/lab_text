package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextStatistics {
    public static void main(String[] args) {
        String inputFilePath = "D:\\txtfile\\in.txt";  // Путь к входному файлу
        String outputFilePath = "D:\\txtfile\\out.txt"; // Путь к файлу для вывода статистики

        try {
            // Чтение текста из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            StringBuilder text = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            reader.close();

            // Подсчет статистики
            String content = text.toString();
            int totalCharacters = content.length()-1; // Общее количество символов
            int charactersWithoutSpaces = content.replace(" ", "").length()-1; // Символы без пробелов
            int wordCount = content.trim().split("\\s+").length; // Количество слов

            // Формирование строки с результатами
            String result = "Общее количество символов: " + totalCharacters + "\n" +
                    "Количество символов без пробелов: " + charactersWithoutSpaces + "\n" +
                    "Количество слов: " + wordCount;

            // Вывод в консоль
            System.out.println(result);

            // Запись результата в файл
            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(result);
            writer.close();

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлами: " + e.getMessage());
        }
    }
}
