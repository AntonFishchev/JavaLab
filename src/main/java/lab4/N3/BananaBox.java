package lab4.N3;

public class BananaBox extends Box {
    public void Add(Fruit fruit){
        if (contants.size() == 0){
            contants.add(fruit);
        } else if (contants.get(0).getClass() == fruit.getClass() && fruit.GetTypeFruit() != "Апельсин"  ) {
            contants.add(fruit);
        } else if (contants.get(0).GetTypeFruit() == "Апельсин" && contants.get(0).GetTypeFruit() == fruit.GetTypeFruit()) {
            System.out.println("В коробку нельзя положить апельсин");
        }
    }
}
