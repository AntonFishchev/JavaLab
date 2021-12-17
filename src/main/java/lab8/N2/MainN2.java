package lab8.N2;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class MainN2 {

    /**
     * Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите среднюю зарплату сотрудника.
     */

    public static void main(String[] args) {
        Employee[] arr = {
                new Employee("Вася",     25, 19000, 1),
                new Employee("Антон",    40, 43000, 2),
                new Employee("Ольга",    23, 26000, 1),
                new Employee("Анатолий", 29, 33000, 2),
                new Employee("Петр",     35, 38000, 2),
                new Employee("Николай",  30, 35000, 1),
                new Employee("Егор",     19, 17000, 1)
        };

        OptionalDouble avgSalary = Stream.of(arr)
                .mapToInt(employee -> employee.getSalary())
                .average();

        System.out.println(avgSalary.getAsDouble());
    }
}

