package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;

public class Knight extends ChessPiece {

    public Knight(int color, int x, int y) {
        super(color, KNIGHT, x, y);
    }

    @Override
    public ArrayList<ChessMove> getValidMoves() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        int targetX;
        int targetY;
        if (y > 0) { //do moves the move 1 square up
            targetY = y - 1;
            if (x > 1) { //up one left 2
                targetX = -2;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    if (ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                        moves.add(new ChessMove(this, targetX, targetY));
                    }
                }
            }

        }
        return moves;
    }
}
