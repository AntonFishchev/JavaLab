package lab4.N2;

import java.util.ArrayList;

public class MainN2 {
    public static void main(String[] args){
        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println("Тип intArr - " + intArr.getClass() );
        for(int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i] + " ");
        }
        ArrayList<Integer> intList = ArrayToArrayList(intArr);
        System.out.println("\nТип intArr - " + intList.getClass() );
        for(int i = 0; i < intList.size(); i++){
            System.out.print(intList.get(i) + " ");
        }

        String[] strArr = {"один", "два", "три", "четыре", "пять"};
        System.out.println("\n\nТип strArr - " + strArr.getClass() );
        for(int i = 0; i < strArr.length; i++){
            System.out.print(strArr[i] + " ");
        }
        ArrayList<String> strList = ArrayToArrayList(strArr);
        System.out.println("\n\nТип strList - " + strList.getClass() );
        for(int i = 0; i < strList.size(); i++){
            System.out.print(strList.get(i) + " ");
        }
    }

    public static <T> ArrayList<T> ArrayToArrayList(T[] arr){
        ArrayList<T> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            list.add(arr[i]);
        }
        return list;
    }
}

