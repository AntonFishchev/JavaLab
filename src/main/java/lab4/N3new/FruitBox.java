package lab4.N3new;

import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<T extends Fruit> extends Box {

    public FruitBox(T... items) {
        super.contants = new ArrayList<T>(Arrays.asList(items));
    }

    public Boolean Add(Apple fruit){
        for (Object item : contants){
            if (item == fruit){
                return false;
            }
        }
        contants.add( (T)fruit );
        return true;
    }

    public Boolean Add(Banana fruit){
        for (Object item : contants){
            if (item == fruit){
                return false;
            }
        }
        contants.add( (T)fruit );
        return true;
    }

//    public void Pour(FruitBox<Apple> box){
//        for (Object item : contants) {
//            box.Add((Apple) item);
//        }
//        this.Clear();
//    }

    public void Pour(FruitBox<Banana> box){
        for (Object item : contants) {
            box.Add((Banana) item);
        }
        this.Clear();
    }
}
