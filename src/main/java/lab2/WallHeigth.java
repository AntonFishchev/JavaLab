package lab2;

public enum WallHeigth {
    LOW("LOW", 10),
    MIDDLE("MIDDLE", 50),
    HIGH("HIGH", 200);

    String name ;
    int heigth;

    WallHeigth(String name, int heigth) {
        this.name = name;
        this.heigth = heigth;
    }

    public int getHeigth() {
        return heigth;
    }
}
