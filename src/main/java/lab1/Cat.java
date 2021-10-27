package lab1;

public class Cat extends Animal {

    static int count;

    public Cat(){
        count++;
    }

    public void ToRun(int distance){
        if (distance <= 200){
            System.out.println(name + " пробежал " + distance + " м.");
        }
        else{
            System.out.println(name + " не может пробежать " + distance + " м");
        }
    }

    public void ToRun(float distance){
        if (distance <= 200.0){
            System.out.println(name + " пробежал " + distance + " м.");
        }
        else{
            System.out.println(name +" не может пробежать " + distance + " м");
        }
    }

    public void ToSwim(int distance){
        System.out.println(name + " не умеет плавать");
    }


    public void ToSwim(float distance){
        System.out.println(name + " не умеет плавать");
    }
}
