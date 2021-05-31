package controllers;

import player.enums.ChessboardStyle;
import player.manager.LoginManager;

public class StyleManager {

    public static String colorBoard = "rgba(50,50,50)";

    public static String getColorBoard() {
        return colorBoard;
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
