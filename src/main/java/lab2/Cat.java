package lab2;

public class Cat implements IParticipant, ISuperJump {
    private String name;
    private Integer heigthJump;
    private Integer lengthRun;
    private Integer lvl = 0;

    public Cat(String name, int heigthJump, int lengthRun){
        this.name = name;
        this.heigthJump = heigthJump;
        this.lengthRun = lengthRun;
    }

    public String GetName(){
        return name;
    }

    @Override
    public Boolean IsSuperJumper() {
        return true;
    }

    public Boolean superJump = true;
    public Boolean SuperJump(){
        if (superJump){
            superJump = false;
            return true;
        }
        else {
            return false;
        }
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
