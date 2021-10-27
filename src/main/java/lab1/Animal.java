package lab1;

public class Animal {
    public String name;
    public Integer age;
    static int count;

    public void ToRun(int distance){
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void ToRun(float distance){
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void ToSwim(int distance){
        System.out.println(name + " проплыл " + distance + " м.");
    }

    public void ToSwim(float distance){
        System.out.println(name + " проплыл " + distance + " м.");
    }
}
