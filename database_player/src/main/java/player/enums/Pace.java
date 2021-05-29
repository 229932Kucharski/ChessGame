package player.enums;

public enum Pace {
    menu("Wybierz tempo gry"),
    bullet1_0("bullet 1 | 0"), //1 minuta 0 inkrementacji
    bullet1_1("bullet 1 | 1"),
    blitz3_0("blitz 3 | 0"),
    blitz5_0("blitz 5 | 0"),
    blitz5_5("blitz 5 | 5"),
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
