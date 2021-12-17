package lab4.N3;

public class MainN3 {
    public static void main(String[] args){
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        Box box1 = new Box();
        Box box2 = new Box();

        Box box3 = new BananaBox();
        Fruit banana = new Banana();

//        box3.Add(banana);
//        box3.Add(apple);
//        box3.Info();

//        box3.Add(orange);
//        box3.Add(apple);
//        box3.Info();

        box3.Add(apple);
        box3.Add(orange);
        box3.Info();

//        int bs1 = 3;
//        int bs2 = 4;
//        for(int i = 0; i < bs1; i++) box1.Add(apple);
//        for(int i = 0; i < bs2; i++) box2.Add(orange);
//
//        box1.Info();
//        System.out.println("Вес коробки 1 - " + box1.GetWeight());
//        System.out.println("Вес коробки 2 - " + box2.GetWeight());
//
//
//        if (box1.Compare(box2)){
//            System.out.println("Коробки одного веса");
//        } else {
//            System.out.println("Коробки разного веса");
//        }
//
//        box1.Pour(box2);
//
//        System.out.println("Вес коробки - " + box1.GetWeight());
//        System.out.println("Вес коробки - " + box2.GetWeight());

    }
}

