package lab6;

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

    static final int size = 10000000;
    static final int half = size / 2;

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
    }


    public static synchronized void method2() throws InterruptedException {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) { arr[i] = 1; }

        long a = System.currentTimeMillis();

        float[] arr1 = new float[half];
        float[] arr2 = new float[half];

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        System.arraycopy(arr, 0, arr1, 0, half);
        System.arraycopy(arr, half, arr2, 0, half);

        thread1.arr = arr1;
        thread2.arr = arr2;

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        arr1 = thread1.arr;
        arr2 = thread2.arr;

        System.arraycopy(arr1, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, half, half);

        System.out.println("Время выполнения 2 метода - " + (System.currentTimeMillis() - a) + " мс");
    }
}




