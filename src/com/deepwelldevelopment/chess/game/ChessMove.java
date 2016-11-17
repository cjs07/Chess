package com.deepwelldevelopment.chess.game;

import com.deepwelldevelopment.chess.game.piece.ChessPiece;

import java.util.ArrayList;

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

    public void move() {
        ArrayList<ChessMove> legalPiceMoves = piece.getValidMoves();
        for (ChessMove move : legalPiceMoves) {
            if (move.equals(this)) {
                piece.move(targetX, targetY);
            }
        }
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChessMove) {
            ChessMove testMove = ((ChessMove) obj);
            if (testMove.getPiece().equals(piece)) {
                if (testMove.getTargetX() == targetX) {
                    return testMove.getTargetY() == targetY;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
