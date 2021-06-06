package Algorithm;

public class CoordinatesConverter {

    public static int convert(int algoY) {
        if(algoY == 0) {
            algoY = 7;
        } else if(algoY == 1) {
            algoY = 6;
        } else if(algoY == 2) {
            algoY = 5;
        } else if(algoY == 3) {
            algoY = 4;
        } else if(algoY == 4) {
            algoY = 3;
        } else if(algoY == 5) {
            algoY = 2;
        } else if(algoY == 6) {
            algoY = 1;
        } else if(algoY == 7) {
            algoY = 0;
        }
        return algoY;
    }

}
