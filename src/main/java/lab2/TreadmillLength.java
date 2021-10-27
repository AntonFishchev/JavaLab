package lab2;

public enum TreadmillLength {
    SHORT("SHORT", 100),
    MIDDLE("MIDDLE", 500),
    LONG("LONG", 2000);

    String name;

    int length;

    TreadmillLength(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

}
