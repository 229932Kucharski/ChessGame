package code;

import controllers.Stopwatch;

public class Game {
    private Stopwatch whitePlayerTime;
    private Stopwatch blackPlayTime;
    public void initGame() {

    }
    public boolean isCheckmate() {
        //sprawdzmy czy nie wystąpił szach-mat --> król ma zablokowane wszytskie ruchy
        return false;
    }
    public boolean isCheck() {
        //król ma zablokowany ruch/ruchy poprzez inną figurę, która mu zagraża biciem
        return false;
    }
    public boolean isStalemate() {
        //sprawdzamy czy król nie ma leglnych ruchów
        return false;
    }

}
