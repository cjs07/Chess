package com.deepwelldevelopment.chess.game;

import com.deepwelldevelopment.chess.game.piece.ChessPiece;

public class ChessMove {

    ChessPiece piece;
    int targetX;
    int targetY;
    boolean isLeagl;

    public ChessMove(ChessPiece piece, int targetX, int targetY) {
        this.piece = piece;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    public boolean isLeagl() {
        return isLeagl;
    }
}
