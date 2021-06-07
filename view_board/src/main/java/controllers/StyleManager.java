package controllers;

import player.enums.ChessboardStyle;
import player.enums.FiguresStyle;
import player.manager.LoginManager;

public class StyleManager {

    public static String colorBoard = "rgba(50,50,50)";
    public static String figuresStyle = "classic";

    public static String getColorBoard() {
        return colorBoard;
    }

    public static String getFiguresStyle() { return figuresStyle; }

    public static void setFiguresStyle(FiguresStyle fs) {
        if(LoginManager.getLoggedUser() != null) {
            LoginManager.getLoggedUser().setPieceDesign(fs);
        }
        if(fs.equals(FiguresStyle.classic)) {
            figuresStyle = "classic";
        }
        else if(fs.equals(FiguresStyle.wooden)) {
            figuresStyle = "wooden";
        }
    }

    public static void setBoardColor(ChessboardStyle cs) {
        if(LoginManager.getLoggedUser() != null) {
            LoginManager.getLoggedUser().setBoardDesign(cs);
        }
        if(cs.equals(ChessboardStyle.classic)) {
            colorBoard = "rgba(50,50,50)";
        }
        else if(cs.equals(ChessboardStyle.marble)) {
            colorBoard = "rgba(128,128,128)";
        }
        else if(cs.equals(ChessboardStyle.wooden)) {
            colorBoard = "rgba(120,50,35)";
        }
    }
}
