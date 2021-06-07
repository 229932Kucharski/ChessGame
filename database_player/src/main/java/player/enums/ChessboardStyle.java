package player.enums;

public enum ChessboardStyle {
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
    public static ChessboardStyle fromString(String txt) {
        for (ChessboardStyle cs: ChessboardStyle.values()) {
            if(cs.cb.equals(txt)){
                return cs;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return cb;
    }
}
