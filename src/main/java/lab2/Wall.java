package lab2;

public class Wall implements IObstacle {
    private Integer heigth;

    public Wall(WallHeigth wh ){
        this.heigth = wh.getHeigth();
    }

    @Override
    public boolean Passing(IParticipant participant) {
        return (participant.ToJump() > heigth);
    }
}
