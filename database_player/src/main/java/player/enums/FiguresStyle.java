package player.enums;

public enum FiguresStyle {
    menu("Wybierz styl figur"),
    classic("klasyczny"),
    wooden("drewniany"),
    marble("marmurowy");
    private String fig;
    FiguresStyle(String s) {
        fig = s;
    }
    public String getFig(){
        return fig;
    }
    public static FiguresStyle fromString(String txt) {
        for (FiguresStyle fs: FiguresStyle.values()) {
            if(fs.fig.equals(txt)){
                return fs;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return fig;
    }
}
