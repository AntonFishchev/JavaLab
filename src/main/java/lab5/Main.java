package lab5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        String[] wordsArray = {
                "Один","Один",
                "Два","Два","Два","Два","Два","Два",
                "Три","Три",
                "Четыре",
                "Пять","Пять",
                "Шесть",
                "Семь","Семь","Семь","Семь","Семь","Семь","Семь","Семь",
                "Восемь",
                "Девять",
                "Десять",
                "Одинадцать","Одинадцать",
        };

        HashSet<String> wordsSet = new HashSet<String>();
        HashMap<String, Integer> countWords = new HashMap<>();

        int lenHS = 0;
        int count = 0;
        for(String str : wordsArray){

            wordsSet.add(str);
            lenHS += 1;

            if(wordsSet.size() == lenHS){
                countWords.put(str, 1);
            }
            else {
                count = countWords.get(str);
                countWords.put(str, count += 1);
                count = 0;
                lenHS = wordsSet.size();
            }
        }

        for(String item : wordsSet){
            System.out.println(item);
        }

        for(Map.Entry<String, Integer> item : countWords.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue());
        }


    }
}
