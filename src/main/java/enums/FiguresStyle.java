package enums;

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

    @Override
    public String toString() {
        return fig;
    }
}
