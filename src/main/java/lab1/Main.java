package lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Кол-во животных в цепи
        int n = 3;
        Animal[] arrayAnimal = new Animal[n];

        for (int i = 0; i < n; i++){

            System.out.println("Выберите кого создать: \n 1. Кота \n 2. Собаку");

            int choose = scanner.nextInt();
            if (choose == 1){
                arrayAnimal[i] = new Cat();
                System.out.println("Придумайте имя коту");
                arrayAnimal[i].name = scanner.next();
            }
            else if (choose == 2){
                arrayAnimal[i] = new Dog();
                System.out.println("Придумайте имя собаке");
                arrayAnimal[i].name = scanner.next();
            }
            else {
                System.out.println("Выберите 1 или 2");
            }
        }

        System.out.println("Введите дистанцию пробежки");
        int distanceRun = scanner.nextInt();

        System.out.println("Введите дистанцию плаванья");
        int distanceSwim = scanner.nextInt();

        for (Animal a : arrayAnimal){
            a.ToRun(distanceRun);
            a.ToSwim(distanceSwim);
        }

        System.out.println("\nКоличество животных - " + n + "\nКоличество котов - " + Cat.count + "\nКоличество собак - " + Dog.count);

    }
}