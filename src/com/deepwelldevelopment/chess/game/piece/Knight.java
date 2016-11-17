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
        try {
            targetX = x+2;
            targetY = y+1;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x+1;
            targetY = y+2;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x-1;
            targetY = y+2;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x-2;
            targetY = y+1;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x-2;
            targetY = y-1;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x-1;
            targetY = y-2;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x+1;
            targetY = y-2;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        try {
            targetX = x+2;
            targetY = y-1;
            if (ChessGame.instance.pieceAt(targetX, targetY) == null || ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                moves.add(new ChessMove(this, targetX, targetY));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //this move would move off the board
        }

        return moves;
    }
}
