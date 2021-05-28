package enums;

public enum ChessboardStyle {
    menu("Wybierz styl szachownicy"),
    classic("klasyczny"),
    wooden("drewniany"),
    marble("marmurowy");
    private String cb;
    ChessboardStyle(String s) {
        cb = s;
    }
    public String getFig(){
        return cb;
    }

    @Override
    public String toString() {
        return cb;
    }
}
