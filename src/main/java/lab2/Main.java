package lab2;

public class Main {
    public static void main(String[] args){
        IParticipant[] arr1 = {
                new Human("Вася", 120, 2300),
                new Cat("Барсик", 150, 600),
                new Robot("R2D2", 40, 40)
        };

        IObstacle[] arr2 = {
                new Wall(WallHeigth.LOW),
                new Treadmill(TreadmillLength.SHORT),
                new Wall(WallHeigth.HIGH)
        };

        for(IParticipant a : arr1) {

            boolean win = false;
            int numberOfPassedStages = 0;

            for (IObstacle b : arr2) {
                if (b.Passing(a)){
                    win = true;
                }
                else{
                    win = false;
                    break;
                }
                numberOfPassedStages++;
            }

            a.SetLvl(numberOfPassedStages);
            if (win){
                System.out.println(a.GetName() + " прошел дистанцию.\n" + "Пройдено этапов - " + a.GetLvl());
            }
            else {
                System.out.println(a.GetName() + " не прошел дистанцию.\n" + "Пройдено этапов - " + a.GetLvl());
            }
        }
    }
}
