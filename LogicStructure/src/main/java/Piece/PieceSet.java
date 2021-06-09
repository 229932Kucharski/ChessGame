package Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PieceSet {

    private final PieceColor pieceColor;
    protected int score = 40;
    protected List<Piece> pieces = new ArrayList<>();
    protected List<Piece> removedPieces = new ArrayList<>();
    protected List<Move> possibleMoves = new ArrayList<>();
    protected List<Move> previousMoves = new ArrayList<>();

    public List<Move> getPossibleMoves() {
        return possibleMoves;
    }

    public PieceSet(PieceColor pieceColor) throws NullPointerException{
        this.pieceColor = pieceColor;
        String ID ;
        int id = 0;
        int pawnY = 0;
        int kingY = 0;

        if(pieceColor == PieceColor.WHITE) {
            ID = "W00" + id;
            pawnY = 6;
            kingY = 7;
        } else {
            ID = "B00" + id;
            kingY = 0;
            pawnY = 1;
        }

        for(int x = 0; x < 8; x ++) {
            pieces.add(new Pawn(x, pawnY, pieceColor, 1, ID));
            id++;
            if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
            else ID = "B00" + id;
        }
        pieces.add(new Rook(0, kingY, pieceColor, 5, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new Knight(1, kingY, pieceColor, 3, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new Bishop(2, kingY, pieceColor, 3, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new Queen(3, kingY, pieceColor, 10, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new King(4, kingY, pieceColor, 0, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new Bishop(5, kingY, pieceColor, 3, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new Knight(6, kingY, pieceColor, 3, ID));
        id++;
        if(pieceColor == PieceColor.WHITE) ID = "W00" + id;
        else ID = "B00" + id;
        pieces.add(new Rook(7, kingY, pieceColor, 5, ID));

    }

    public void calculatePossibleMoves(PieceSet enemyPiece){
        possibleMoves.clear();
        for(Piece piece : pieces){
            List<Piece> allOtherPieces = new ArrayList<>();
            allOtherPieces.addAll(enemyPiece.getPieces());
            for(int i = 0; i < pieces.size(); i++) {
                if(pieces.get(i) != piece) {
                    allOtherPieces.add(pieces.get(i));
                }
            }
            if(piece instanceof King){
                Move[] kingsMoves = piece.getPossibleMoves(allOtherPieces);
                possibleMoves.addAll(Arrays.asList(kingsMoves));
                List<Move> hostileMoves = new ArrayList<>(enemyPiece.possibleMoves);
                for (Move hostileMove : hostileMoves){
                    if((hostileMove.getNextX() == piece.currentX)&&(hostileMove.getNextY() == piece.currentY)){
                        ((King) piece).setDanger(true);
                    }
                    for (Move kingsMove : kingsMoves){
                        if((kingsMove.getNextX() == hostileMove.getNextX()) && ((kingsMove.getNextY() == hostileMove.getNextY()))){
                            possibleMoves.remove(kingsMove);
                        }
                    }
                }
            }else {


                Move[] moves = piece.getPossibleMoves(allOtherPieces);
                possibleMoves.addAll(Arrays.asList(moves));
            }
            
        }

    }

    public  boolean move(Move move, PieceSet enemyPiece) {
        calculatePossibleMoves(enemyPiece);
            for(Move possibleMove : possibleMoves) {

                if(possibleMove.equals(move)) {
                    Piece piece = this.getPiece(move.getCurrentX(), move.getCurrentY());
                    piece.move(move.getNextX(), move.getNextY());
                    previousMoves.add(possibleMove);
                    if(possibleMove.isAttack()) {
                        removedPieces.add(enemyPiece.getPiece(move.getNextX(), move.getNextY()));
                        enemyPiece.removePiece(enemyPiece.getPiece(move.getNextX(), move.getNextY()));
                    }
                    return true;
                }
            }
        return false;
    }


    public void unmakeMove(PieceSet enemyPiece){
        int i = previousMoves.size();
        Move move = previousMoves.get(i -1);
        Piece piece  = this.getPiece(move.getNextX(), move.getNextY());
        piece.move(move.getCurrentX(),move.getCurrentY());
        if (move.isAttack()){
            int j = removedPieces.size();
            enemyPiece.pieces.add(removedPieces.get(j-1));
            removedPieces.remove(removedPieces.get(j-1));
        }


    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public int getPieceSetSize() {
        return pieces.size();
    }

    public boolean isCheck(){
        for(Piece piece : pieces) {
            if ((piece instanceof King) && (((King) piece).isDanger())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCheckMate(){
        if(getPieceSetSize() == 1){
            if(pieces.get(0) instanceof King){
                return possibleMoves.equals(0);
            }
        }
        return false;
    }


    public Piece getPiece(int x, int y) {
        for(Piece piece : pieces) {
            if( (piece.getCurrentX() == x) && (piece.getCurrentY() == y) ) {
                return piece;
            }
        }
        return null;
    }

    public int getScore() {

        return  score;
    }



    public boolean removePiece(Piece piece) {
        score -= piece.getValue();
        return pieces.remove(piece);
    }

    public List<Piece> getPieces() {
        return pieces;
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
