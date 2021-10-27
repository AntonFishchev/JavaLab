package lab4.N1;

public class MainN1 {
    public static void main(String[] args){

        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println("Исходный массив");
        for(int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i] + " ");
        }
        SwapItemArrayToIndex(  intArr, 1, 3);
        System.out.println("\nИзмененный массив");
        for(int i = 0; i < intArr.length; i++){
            System.out.print(intArr[i] + " ");
        }

        String[] strArr = {"один", "два", "три", "четыре", "пять"};
        System.out.println("\nИсходный массив");
        for(int i = 0; i < strArr.length; i++){
            System.out.print(strArr[i] + " ");
        }
        SwapItemArrayToIndex(strArr, 1, 3);
        System.out.println("\nИзмененный массив");
        for(int i = 0; i < strArr.length; i++){
            System.out.print(strArr[i] + " ");
        }
    }

    public static <T> void SwapItemArrayToIndex(T[] arr, int i1, int i2) {
        T a = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = a;
    }
}

