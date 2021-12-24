package lab6;

import java.util.ArrayList;

public class Main {

    /**
     * 1.Необходимо написать два метода, которые делают следующее
     * 1)Создают одномерный длинный массив, например.
     * 2)Заполняют этот массив единицами.
     * 3)Засекают время выполнения: long a = System.currentTimeMillis().
     * 4)Проходят по всему массиву и для каждой ячейки считают новое значение по формуле: arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i /2)).
     * 5)Проверяется время окончания метода System.currentTimeMillis().
     * 6)В консоль выводится время работы: System.out.println(System.currentTimeMillis() -a).
     *
     * Для первого метода надо считать время только на цикл расчета.
     * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
     */

    static final int size = 120000000;
    static final int half = size / 2;
    static final int countThread = 6;

    public static void main(String[] args) throws InterruptedException {
        method1();
        method2();
    }

    public static void method1(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) { arr[i] = 1; }

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i /2));
        }

        System.out.println("Время выполнения 1 метода - " + (System.currentTimeMillis() - start) + " мс");

        System.out.println(arr[size - 1]);
    }


    public static synchronized void method2() throws InterruptedException {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        ArrayList<float[]> arrs = new ArrayList<>();

        int countSubArrays = 1;
        for (int i = 0; i < countThread; i++){
            float[] subArray = new float[arr.length / countThread];
            System.arraycopy(
                    arr,
                    i * arr.length / countThread,
                    subArray,
                    0,
                    arr.length / countThread
            );
            arrs.add(subArray);
            countSubArrays++;
        }

        MyThread[] threads = new MyThread[countThread];

        threads[0] = new MyThread(arrs.get(0), 0);
        threads[0].start();
        for (int i = 1; i < countThread; i++){
            threads[i] = new MyThread(arrs.get(i), arr.length / countThread * i - 1);
            threads[i].start();
        }

        for (MyThread item : threads){
            item.join();
        }

        for(int i = 0; i < countThread; i++){
            arrs.set(i, threads[i].arr);
        }

        //countSubArrays = 1;
        for (int i = 0; i < countThread; i++){
            System.arraycopy(arrs.get(i), 0, arr, i * arr.length / countThread, arr.length / countThread);
            countSubArrays++;
        }

        System.out.println("Время выполнения 2 метода - " + (System.currentTimeMillis() - a) + " мс");

        System.out.println(arr[size - 1]);
    }
}




