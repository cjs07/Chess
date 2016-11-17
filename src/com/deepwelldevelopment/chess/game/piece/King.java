package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;

public class King extends ChessPiece {

    public King(int color, int x, int y) {
        super(color, KING, x, y);
    }

    @Override
    public ArrayList<ChessMove> getValidMoves() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        if (ChessGame.instance.canKingMoveTo(color, x + 1, y)) {
            moves.add(new ChessMove(this, x + 1, y));
        }

        if (ChessGame.instance.canKingMoveTo(color, x + 1, y + 1)) {
            moves.add(new ChessMove(this, x + 1, y + 1));
        }

        if (ChessGame.instance.canKingMoveTo(color, x, y + 1)) {
            moves.add(new ChessMove(this, x, y + 1));
        }

        if (ChessGame.instance.canKingMoveTo(color, x - 1, y + 1)) {
            moves.add(new ChessMove(this, x - 1, y + 1));
        }

        if (ChessGame.instance.canKingMoveTo(color, x - 1, y)) {
            moves.add(new ChessMove(this, x - 1, y));
        }

        if (ChessGame.instance.canKingMoveTo(color, x - 1, y - 1)) {
            moves.add(new ChessMove(this, x - 1, y - 1));
        }

        if (ChessGame.instance.canKingMoveTo(color, x, y - 1)) {
            moves.add(new ChessMove(this, x, y - 1));
        }

        if (ChessGame.instance.canKingMoveTo(color, x + 1, y - 1)) {
            moves.add(new ChessMove(this, x + 1, y - 1));
        }

        return moves;
    }
}
