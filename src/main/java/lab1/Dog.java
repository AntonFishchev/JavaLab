package lab1;

import lab1.Animal;

public class Dog  extends Animal {

    static int count;

    public Dog(){
        count++;
    }


    public void ToRun(int distance){
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        }
        else{
            System.out.println(name + " не может пробежать " + distance + " м");
        }
    }

    public void ToRun(float distance){
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        }
        else{
            System.out.println(name + " не может пробежать " + distance + " м");
        }
    }

    public void ToSwim(int distance){
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
        else{
            System.out.println(name + " не может проплыть " + distance + " м");
        }
    }

    public void ToSwim(float distance){
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        }
        else{
            System.out.println(name + " не может проплыть " + distance + " м");
        }
    }
}
