package lab9;

@Table(name = "Employee")
public class Employee {

    @Column(name = "id", type = "serial", PK = true)
    private Integer id;

    @Column(name = "name", type = "varchar(255)")
    private String name;

    @Column(name = "age", type = "smallint")
    private Integer age;

    @Column(name = "salary", type = "int")
    private Integer salary;

    @Column(name = "department", type = "int")
    private Integer department;

    public Employee(String name, Integer age, Integer salary, Integer department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }
}
