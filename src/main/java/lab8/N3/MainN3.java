package lab8.N3;

import lab8.N2.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainN3 {

    /**
     * 3.Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших сотрудников
     * и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут: имя1, имя2, имяN;”.
     */

    public static void main(String[] args) {
        Employee[] arr = {
                new Employee("Вася",     25, 19000),
                new Employee("Антон",    40, 43000),
                new Employee("Ольга",    23, 26000),
                new Employee("Анатолий", 29, 33000),
                new Employee("Петр",     35, 38000),
                new Employee("Николай",  30, 35000),
                new Employee("Егор",     19, 17000),
        };


        OldEmployee(arr, 3);
    }

    public static void OldEmployee(Employee[] arr, int n){
        System.out.print(n + " самых старших сотрудников зовут: ");
        List<String> name = Arrays.stream(arr)
                .sorted((employee1, employee2) -> employee2.getAge() - employee1.getAge() )
                .limit(n)
                .map(person -> person.getName())
                .collect(Collectors.toList());

        for(String item : name){
            if (item.equals(name.get(name.size() - 1))){
                System.out.print(item + ";");
            } else {
                System.out.print(item + ", ");
            }
        }


        System.out.println("\n\nПроверка:");
        Arrays.stream(arr)
                .sorted((employee1, employee2) -> employee2.getAge() - employee1.getAge())
                .forEach(System.out::println);
    }
}
