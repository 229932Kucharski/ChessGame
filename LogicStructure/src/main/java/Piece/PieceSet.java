package Piece;

import java.util.ArrayList;
import java.util.List;

public class PieceSet {

    private PieceColor pieceColor;
    protected List<Piece> pieces = new ArrayList<>();
    protected List<Move[]> possibleMoves = new ArrayList<Move[]>();

    public PieceSet(PieceColor pieceColor) throws NullPointerException{
        this.pieceColor = pieceColor;
        int id = 0;
        int pawnY = 0;
        int kingY = 0;
        if(pieceColor == PieceColor.WHITE) {
            pawnY = 1;
            kingY = 0;
        } else {
            kingY = 7;
            pawnY = 6;
        }

        for(int x = 0; x < 8; x ++) {
            pieces.add(new Pawn(x, pawnY, pieceColor, id));
            id++;
        }
        pieces.add(new Rook(0, kingY, pieceColor, id));
        id++;
        pieces.add(new Knight(1, kingY, pieceColor, id));
        id++;
        pieces.add(new Bishop(2, kingY, pieceColor, id));
        id++;
        pieces.add(new Queen(3, kingY, pieceColor, id));
        id++;
        pieces.add(new King(4, kingY, pieceColor, id));
        id++;
        pieces.add(new Bishop(5, kingY, pieceColor, id));
        id++;
        pieces.add(new Knight(6, 7, pieceColor, id));
        id++;
        pieces.add(new Rook(7, 7, pieceColor, id));
    }

    public boolean move(Move move) {
        for(Piece piece : pieces) {

            Move[] moves = piece.getPossibleMoves();

            for(Move possibleMove : moves) {

                if(possibleMove.equals(move)) {
                    piece.move(move.getNextX(), move.getNextY());
                    possibleMoves.add(piece.getPossibleMoves());
                    return true;
                }

            }
        }
        return false;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getPieceSetSize() {
        return pieces.size();
    }

    public Piece getPiece(int x, int y) {
        for(Piece piece : pieces) {
            if( (piece.getCurrentX() == x) && (piece.getCurrentY() == y) ) {
                return piece;
            }
        }
        return null;
    }

    public boolean removePiece(Piece piece) {
        return pieces.remove(piece);
    }

    public boolean isCastlingAvailable() {
        List<Rook> rooks = new ArrayList<>();
        King king = null;
        for(Piece piece : pieces) {
            if(piece instanceof Rook) {
                rooks.add((Rook)piece);
            } else if(piece instanceof King) {
                king = (King)piece;
            }
        }
        if( (king == null) || (king.wasMoved()) ) {
            return false;
        }
        for(Rook rook : rooks) {
            if(!rook.wasMoved()) {
                return true;
            }
        }
        return false;
    }

    public void doCastling(King king, Rook rook) {
        if( (!king.wasMoved()) && (!rook.wasMoved()) ) {
            if(pieceColor == PieceColor.WHITE) {
                if( (rook.currentX == 0) && (rook.currentY == 0) ) {
                    king.move(2, 0);
                    rook.move(3, 0);
                } else {
                    king.move(6, 0);
                    rook.move(5, 0);
                }
            } else if(pieceColor == PieceColor.BLACK) {
                if( (rook.currentX == 0) && (rook.currentY == 7) ) {
                    king.move(2, 7);
                    rook.move(3, 7);
                } else {
                    king.move(6, 7);
                    rook.move(5, 7);
                }
            }
        }
    }

}
