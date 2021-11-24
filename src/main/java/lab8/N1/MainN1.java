package lab8.N1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
                "Четыре",
                "Пять","Пять",
                "Шесть",
                "Семь","Семь","Семь","Семь","Семь","Семь","Семь","Семь",
                "Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь","Восемь",
                "Девять",
                "Десять",
                "Одинадцать","Одинадцать",
        };

        Stream<String> stream = Stream.of(wordsArray);
        List<String> list = stream.collect(Collectors.toList());

        String mostRepeatedWord = list.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .get()
                    .getKey();;

        System.out.println(mostRepeatedWord);

    }
}
