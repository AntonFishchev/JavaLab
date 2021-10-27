package lab3;

import lab3.Exception.MyArrayDataException;
import lab3.Exception.MyArraySizeException;

public class Main {
    public static Integer CheckArray(String[][] arr){
        Integer sum = 0;

        if (arr.length == 4 && arr[0].length == 4){
            System.out.println("Массив 4 на 4");
        } else {
            try{
                throw new MyArraySizeException("Массив не 4 на 4");
            } catch (MyArraySizeException e) {
                e.printStackTrace();
                return 0;
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                try {
                    sum += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException e){
                    try {
                        throw new MyArrayDataException("Индекс ошибочного элемента - ("
                                + String.valueOf(i + 1) + ":" + String.valueOf(j + 1) + ")");
                    } catch (MyArrayDataException ee){
                        ee.printStackTrace();
                        return 0;
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String args[]){
        String[][] str =
                {
                        {"23", "2", "12", "3"},
                        {"23", "2", "12", "3"},
                {"23", "2", "12", "3"},
                {"23", "2", "12", "3"}};

        System.out.println(CheckArray(str));
    }
}

