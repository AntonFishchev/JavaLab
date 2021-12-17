package lab4.N3new;

import java.util.ArrayList;
import java.util.Arrays;

public class OrangeBox<T extends Fruit> extends Box{

    public OrangeBox(T... items) {
        super.contants = new ArrayList<T>(Arrays.asList(items));
    }

    public Boolean Add(Orange fruit){
        for (Object item : contants){
            if (item == fruit){
                return false;
            }
        }
        contants.add( (T)fruit );
        return true;
    }

//    public Boolean Add(Banana fruit){
//        for (Object item : contants){
//            if (item == fruit){
//                return false;
//            }
//        }
//        contants.add( (T)fruit );
//        return true;
//    }

    public void Pour(FruitBox<Apple> box) {
        Fruit fruit = (Fruit) contants.get(0);
        Fruit fruit2 = (Fruit) box.GetContants().get(0);

        if (fruit2.GetTypeFruit() != "Апельсин")
        for (Object item : contants){
            box.Add((Apple) item);
            this.Clear();
        } else {
            System.out.println("К апельсинам нельзя пересыпать - " + fruit.GetTypeFruit());
        }
    }
}
