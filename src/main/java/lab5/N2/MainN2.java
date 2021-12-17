package lab5.N2;

import java.util.ArrayList;

public class MainN2 {
    public static void main(String[] args){
        Phonebook phonebook = new Phonebook();

        phonebook.add("Ананасов", "1");
        phonebook.add("Барбарисов", "2");
        phonebook.add("Вишнев", "3");
        phonebook.add("Горохов", "4");
        phonebook.add("Дынев", "5");
        phonebook.add("Вишнев", "6");
        phonebook.add("Горохов", "7");

        ArrayList<String> outPhones = phonebook.get("Горохов");
        for(String item : outPhones){
            System.out.println(item);
        }
    }
}
