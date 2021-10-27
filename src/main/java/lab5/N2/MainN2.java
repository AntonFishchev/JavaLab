package lab5.N2;

import java.util.ArrayList;

public class MainN2 {
    public static void main(String[] args){
        Phonebook phonebook = new Phonebook();

        phonebook.set("Ананасов", "1");
        phonebook.set("Барбарисов", "2");
        phonebook.set("Вишнев", "3");
        phonebook.set("Горохов", "4");
        phonebook.set("Дынев", "5");
        phonebook.set("Вишнев", "6");
        phonebook.set("Вишнев", "7");

        ArrayList<String> outPhones = phonebook.get("Вишнев");
        for(String item : outPhones){
            System.out.println(item);
        }
    }
}
