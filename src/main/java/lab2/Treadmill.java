package lab2;

public class Treadmill implements IObstacle{
    private Integer length;

    public Treadmill(TreadmillLength tl){
        this.length = tl.getLength();
    }

    @Override
    public boolean Passing(IParticipant participant) {
        return (participant.ToRun() > length);
    }
}
