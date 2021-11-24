package lab7;


import java.util.concurrent.*;

public class Main {

    /**
     * 1. Перенести приведенный ниже код в новый проект, где мы  организуем гонки.
     * Все участники должны стартовать одновременно, несмотря на разное время подготовки.
     * В тоннель не может одновременно заехать больше половины участников (условность).
     * Попробуйте все это синхронизировать. Когда все завершат гонку, нужно выдать объявление об окончании.
     * Можно корректировать классы (в том числе конструктор машин), и добавлять объекты классов из пакета util.concurrent.
     *
     * Обязательно необходимо объявить победителя гонки, он должен быть только один, и это участник первым закончивший последний этап.
     */

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);//
        CountDownLatch cdl = new CountDownLatch(CARS_COUNT); //

        Race race = new Race(
                new Road(60),
                new Tunnel(),
                new Road(40)
        );

        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb, cdl);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        //
        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //
        try {
            cdl.await();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}



