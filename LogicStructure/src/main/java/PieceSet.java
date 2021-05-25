
import java.util.ArrayList;
import java.util.List;

public class PieceSet {

    private PieceColor pieceColor;
    private List<Piece> pieces = new ArrayList<>();

    public PieceSet(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        int id = 0;
        if(pieceColor == PieceColor.WHITE) {
            for(int x = 0; x < 8; x ++) {
                pieces.add(new Pawn(x, 1, pieceColor, id));
                id++;
            }
            pieces.add(new Rook(0, 0, pieceColor, id));
            id++;
            pieces.add(new Knight(1, 0, pieceColor, id));
            id++;
//            pieces.add(new Bishop(2, 0, pieceColor, id));
//            id++;
//            pieces.add(new Bishop(5, 0, pieceColor, id));
//            id++;
            pieces.add(new Knight(6, 0, pieceColor, id));
            id++;
            pieces.add(new Rook(7, 0, pieceColor, id));

        }
    }

    public boolean move(Move move) {
        for(Piece piece : pieces) {

            Move[] moves = piece.getPossibleMoves();

            for(Move possibleMove : moves) {

                if(possibleMove.equals(move)) {
                    piece.move(move.getNextX(), move.getNextY());
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

}
