package lab2;

public class Human implements IParticipant {
    private String name;
    private Integer heigthJump;
    private Integer lengthRun;
    private Integer lvl = 0;

    public Human(String name, int heigthJump, int lengthRun){
        this.name = name;
        this.heigthJump = heigthJump;
        this.lengthRun = lengthRun;
    }

    public String GetName(){
        return name;
    }

    @Override
    public Boolean IsSuperJumper() {
        return false;
    }

    @Override
    public int ToJump(){
        return heigthJump;
    }

    @Override
    public int ToRun(){
        return lengthRun;
    }

    @Override
    public void SetLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public int GetLvl() {
        return lvl;
    }
}
