package enums;

public enum GameMode {
    GraczKomputer("Graj z komputerem"),
    GraczGracz("Graj z innym graczem"),
    KomputerKomputer("Komputer vs Komputer");
    private String mode;
    GameMode(String s) {
        mode = s;
    }
    public String getMode(){
        return mode;
    }

    @Override
    public String toString() {
        return mode;
    }
}
