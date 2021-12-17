package lab8.N3;

import lab8.N2.Employee;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainN3 {

    /**
     * 3.Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших сотрудников
     * и отпечатает в консоль сообщение вида “N самых старших сотрудников зовут: имя1, имя2, имяN;”.
     */

    public static void main(String[] args) {
        Employee[] arr = {
                new Employee("Вася",     25, 19000, 1),
                new Employee("Антон",    40, 43000, 2),
                new Employee("Ольга",    23, 26000, 1),
                new Employee("Анатолий", 29, 33000, 2),
                new Employee("Петр",     35, 38000, 2),
                new Employee("Николай",  30, 35000, 1),
                new Employee("Егор",     19, 17000, 1),
        };


        OldEmployee(arr, 3, 1);
    }

    public static void OldEmployee(Employee[] arr, int n, int department){
//        System.out.print(n + " самых старших сотрудников зовут: ");
//        List<String> name = Arrays.stream(arr)
//                .filter(employee -> employee.getDepartment() == department)
//                .sorted((employee1, employee2) -> employee2.getAge() - employee1.getAge() )
//                .limit(n)
//                .sorted(Comparator.comparing(Employee::getName).reversed())
//                .map(person -> person.getName())
//                .collect(Collectors.toList())
//                ;

        String name = Arrays.stream(arr)
                .filter(employee -> employee.getDepartment() == department)
                .sorted((employee1, employee2) -> employee2.getAge() - employee1.getAge() )
                .limit(n)
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .map(person -> person.getName())
                .collect(Collectors.joining(", ", n + " самых старших сотрудников зовут: ", ";"));

        System.out.println(name);

        System.out.println("\n\nПроверка:");
        Arrays.stream(arr)
                .sorted((employee1, employee2) -> employee2.getAge() - employee1.getAge())
                .forEach(System.out::println);
    }
}
