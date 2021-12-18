package lab9;

public class Main {

    static final String DB_URL = "jdbc:postgresql://[::1]:5432/java";
    static final String USER = "postgres";
    static final String PASS = "1234";

    public static void main(String[] args) {
        ControllerSQL controllerSQL = new ControllerSQL(DB_URL, USER, PASS);

        Employee employee1 = new Employee("Вася",     25, 19000, 1);
        Employee employee2 = new Employee("Антон",    40, 43000, 2);
        Employee employee3 = new Employee("Ольга",    23, 26000, 1);
        Employee employee4 = new Employee("Анатолий", 29, 33000, 2);
        Employee employee5 = new Employee("Петр",     35, 38000, 2);
        Employee employee6 = new Employee("Николай",  30, 35000, 1);
        Employee employee7 = new Employee("Егор",     19, 17000, 1);

        Employee[] arr = {
                new Employee("Вася",     25, 19000, 1),
                new Employee("Антон",    40, 43000, 2),
                new Employee("Ольга",    23, 26000, 1),
                new Employee("Анатолий", 29, 33000, 2),
                new Employee("Петр",     35, 38000, 2),
                new Employee("Николай",  30, 35000, 1),
                new Employee("Егор",     19, 17000, 1)
        };

        controllerSQL.CreateTable(employee1);
        //controllerSQL.InsertToTable(employee1);
        for (Employee employee : arr) {
            controllerSQL.InsertToTable(employee);
        }
    }
}
