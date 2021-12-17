package lab8.N1;

import lab8.N2.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainN1 {

    /**
     * Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто встречающееся;
     */

    public static void main(String[] args) {
        String[] wordsArray = {
                "Один","Один",
                "Два","Два","Два","Два","Два","Два",
                "Три","Три",
                "Пять","Пять",
                "Шесть",
                "Семь","Семь","Семь","Семь","Семь","Семь","Семь","Семь",
                "Четыре","Четыре","Четыре","Четыре","Четыре","Четыре","Четыре","Четыре","Четыре","Четыре","Четыре","Четыре",
                "Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь",
                "Девять", "Десять",
                "Одинадцать","Одинадцать",
        };

        Long maxAmount = Stream.of(wordsArray)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .get()
                    .getValue();

        Stream.of(wordsArray)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxAmount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .forEach(System.out::println);


//        String mostRepeatedWord = list.stream()
//                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
//                .entrySet()
//                    .stream()
//                    .max(Comparator.comparing(Map.Entry::getValue))
//                    .get()
//                    .getKey();
//
//        System.out.println(mostRepeatedWord);

    }
}
