package enums;

public enum Pace {
    menu("Wybierz tempo gry"),
    bullet10("bullet 1 | 0"), //1 minuta 0 inkrementacji
    bullet11("bullet 1 | 1"),
    blitz30("blitz 3 | 0"),
    blitz50("blitz 5 | 0"),
    blitz55("blitz 5 | 5"),
    szybkie10_0("szybkie 10 | 0")
    ;
    private String pace;

    Pace(String s) {
        pace = s;
    }
    public String getPace() {
        return pace;
    }
    @Override public String toString() { return pace; }

}
