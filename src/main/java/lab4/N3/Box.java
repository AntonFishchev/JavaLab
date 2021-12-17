package lab4.N3;

import java.util.ArrayList;

public class Box {
    protected ArrayList<Fruit> contants = new ArrayList<>();

    public ArrayList<Fruit> GetContants() {
        return contants;
    }

    private void Clear(){
        contants.clear();
    }

    public void Info(){
        System.out.println("\nСодержимое коробки:");
        for (Fruit item : contants){
            System.out.println("Фрукт - " + item.GetTypeFruit() + " | Вес - " + item.GetWeigth());
            // System.out.println(item);
        }
        System.out.println();
    }

    public void Add(Fruit fruit){
        if (contants.size() == 0){
            contants.add(fruit);
        } else if (contants.get(0).getClass() == fruit.getClass()){
            contants.add(fruit);
        } else {
            System.out.println("В коробке лежит другой тип фрукта - " + contants.get(0).GetTypeFruit() + ", а не - " + fruit.GetTypeFruit());
        }
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

    public void Pour(Box box){
        if (this.contants.get(0).GetTypeFruit() == box.contants.get(0).GetTypeFruit()){
            for(int i = 0; i < box.GetContants().size(); i++){
                this.Add(box.GetContants().get(i));
            }
            box.Clear();
        } else {
            System.out.println("В коробке другой тип фруктов");
        }

    }
}
