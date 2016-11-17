package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;

public class ChessPiece {

    public static final int PAWN = 0;
    public static final int KNIGHT = 1;
    public static final int BISHOP = 2;
    public static final int ROOK = 3;
    public static final int QUEEN = 4;
    public static final int KING = 5;

    public static final int WHITE = 0;
    public static final int BLACK = 1;

    int color; //white or black
    int type; //pawn, knight, bishop, rook, queen, king

    int x;
    int y;

    public ChessPiece(int color, int type, int x, int y) {
        this.color = color;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        ChessGame.instance.removePiece(this.x, this.y);
        this.x = x;
        this.y = y;
        ChessGame.instance.putPiece(this, x, y);
    }

    public ArrayList<ChessMove> getValidMoves() {
        return null;
    }

    public ArrayList<ChessMove> getAttackedSquares() {
        return null;
    }

    public int getColor() {
        return color;
    }

    public int getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChessPiece) {
            ChessPiece piece = ((ChessPiece) obj);
            if (piece.getColor() == color) {
                if (piece.getType() == type) {
                    if (piece.getX() == x) {
                        return piece.getY() == y;
                    } else {
                        return false;
                    }
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
