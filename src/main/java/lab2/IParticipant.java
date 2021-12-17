package lab2;

public interface IParticipant {
    String GetName();

    Boolean IsSuperJumper();

    int ToJump();
    int ToRun();

    void SetLvl(int lvl);
    int GetLvl();
}
