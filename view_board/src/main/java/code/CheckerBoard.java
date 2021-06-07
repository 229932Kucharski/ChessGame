package code;
import Piece.Piece;
import Piece.PieceColor;
import Piece.PieceSet;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import static java.lang.Math.abs;

public class CheckerBoard {

    PieceSet ps = new PieceSet(PieceColor.WHITE);
    PieceSet psb = new PieceSet(PieceColor.BLACK);
    Piece[][] board = new Piece[8][8];

    public PieceSet getPs() {
        return ps;
    }

    public PieceSet getPsb() {
        return psb;
    }

    public void initBoard() {
        System.out.println(ps.getPieceColor());
        //tutaj ustawiamy figury na planszy
        for(int i = 0; i < 8 ; i++) {
            for(int j = 0; j < 2 ; j++) {
                createBoard(i, j, psb);
            }
        }
        System.out.println(psb.getPieceColor());
        for(int i = 0; i < 8; i++) {
            for (int j = 6; j < 8; j++) {
                createBoard(i, j, ps);
            }
        }
    }

    private void createBoard(int i, int j, PieceSet p) {
        board[i][j] = p.getPiece(i,j);
        if(p.getPiece(i,j) != null) {
            System.out.println(p.getPiece(i, j) + " " + p.getPiece(i, j).getId());
            System.out.println("x: " + p.getPiece(i, j).getCurrentX());
            System.out.println("y: " + p.getPiece(i, j).getCurrentY() + " | board y: " + abs(j-7));
            System.out.println();
        }
    }
    public void movePiece(Piece piece, int newX, int newY) {
        for(int i = 0; i < 8; i ++) {
            for(int j = 0; j < 8; j ++) {
                if(board[i][j] != null) {
                    if(board[i][j] == piece) {
                        board[newX][newY] = piece;
                        board[i][j] = null;
                        return;
                    }
                }
            }
        }
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void fillHBox(HBox hb, String img, int i, int j, int x, int y) {
        if(i == x && j == y) {
            Image image = new Image(String.valueOf(img));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(60);
            imageView.setFitWidth(45);
            hb.getChildren().add(imageView);
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public static void main(String[] args) {
        CheckerBoard cb = new CheckerBoard();
        cb.initBoard();
    }

}
