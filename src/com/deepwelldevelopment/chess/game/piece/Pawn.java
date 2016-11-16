package com.deepwelldevelopment.chess.game.piece;

public class Pawn extends ChessPiece {

    boolean firstMove;

    public Pawn(int color, int x, int y) {
        super(color, PAWN, x, y);
        firstMove = true;
    }
}
