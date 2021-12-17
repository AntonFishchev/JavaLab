package lab4.N3new;

public class MainN3 {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Banana banana1 = new Banana();
        Banana banana2 = new Banana();
        Banana banana3 = new Banana();

        FruitBox<Apple> box1 = new FruitBox<Apple>(apple1, apple2, apple3);
        FruitBox<Orange> box2 = new FruitBox<Orange>(orange1, orange2);
        FruitBox<Banana> boxBanana = new FruitBox<Banana>(banana1, banana2, banana3);

        OrangeBox<Orange> box3 = new OrangeBox<Orange>();

//        box3.Add(orange1);
//        box3.Add(banana1);
//        box3.Add(apple1);
//
//        boxBanana.Add(apple1);
//        boxBanana.Add(orange1);
//
//        box1.Pour(boxBanana);
//        boxBanana.Pour(box1);
//
//        box2.Pour(box3);
//        box3.Pour(box2);

    }
}
