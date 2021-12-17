package lab4.N3new;

import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends  Fruit> {
    protected ArrayList<T> contants = new ArrayList<>();

    public Box(T... items) {
        this.contants = new ArrayList<T>(Arrays.asList(items));
    }

    public void Info(){
        System.out.println("\nСодержимое коробки:");
        for (Fruit item : contants){
            System.out.println("Фрукт - " + item.GetTypeFruit() + " | Вес - " + item.GetWeigth());
            //System.out.println(item);
        }
        System.out.println();
    }

    public ArrayList<T> GetContants() {
        return contants;
    }

    protected void Clear(){
        contants.clear();
    }

//    public Boolean Add(Object fruit){
//        for (T item : contants){
//            if (item == fruit){
//                return false;
//            }
//        }
//        contants.add( (T)fruit );
//        return true;
//    }

    public Boolean Remove(T fruit){
        for (T item : contants){
            if (fruit == item){
                contants.remove(fruit);
                return true;
            }
        }
        return false;
    }

    public float GetWeight(){
        float _weight = 0;
        for(int i = 0; i < contants.size(); i++){
            _weight += contants.get(i).GetWeigth();
        }
        return _weight;
    }

    public boolean Compare(Box box){
        return (Math.abs(this.GetWeight() - box.GetWeight()) < 0.001f);
    }
}
