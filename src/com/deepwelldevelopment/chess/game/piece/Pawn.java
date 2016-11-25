package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;
import java.util.Iterator;

public class Pawn extends ChessPiece {

    boolean firstMove;

    public Pawn(int color, int x, int y) {
        super(color, PAWN, x, y);
        firstMove = true;
    }

    @Override
    public void move(int x, int y) {
        super.move(x, y);
        firstMove = false;
    }

    @Override
    public ArrayList<ChessMove> getValidMoves() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        //check if it is the pawns first move because they can move two spaces on first move only
        int targetY;
        if (firstMove) {
            if (color == WHITE) {
                targetY = y - 2;
            } else {
                targetY = y + 2;
            }
            if (ChessGame.instance.pieceAt(x, targetY) == null) {
                moves.add(new ChessMove(this, x, targetY)); //two squares forward
            }
        }
        if (color == WHITE) {
            targetY = y - 1;
        } else {
            targetY = y + 1;
        }
        if (ChessGame.instance.pieceAt(x, targetY) == null) {
            moves.add(new ChessMove(this, x, targetY)); //two squares forward
        }

        //check for diagonal jumps
        int targetX;
        if (x < 7) {
            targetX = x + 1;
            if (ChessGame.instance.pieceAt(targetX, targetY) != null && ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) { //there is an opposing piece diagonal to us
                moves.add(new ChessMove(this, targetX, targetY));
            }
        }

        if (x > 0) {
            targetX = x - 1;
            if (ChessGame.instance.pieceAt(targetX, targetY) != null && ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) { //there is an opposing piece diagonal t) { //there is piece diagonal to us
                moves.add(new ChessMove(this, targetX, targetY));
            }
        }

        //TODO: EN PASSANT

        //remove moves that would cause a check, or do not save a king from check
        Iterator<ChessMove> iterator = moves.iterator();
        while (iterator.hasNext()) {
            ChessMove move = iterator.next();
            if (!ChessGame.instance.isNewBoardLegal(ChessGame.instance.pseudoMove(move), ChessGame.instance.getTurn())) {
                iterator.remove();
            }
        }

        return moves;
    }

    @Override
    public ArrayList<ChessMove> getAttackedSquares() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        if (color == WHITE) {
            moves.add(new ChessMove(this, x + 1, y - 1));
            moves.add(new ChessMove(this, x - 1, y - 1));
        } else {
            moves.add(new ChessMove(this, x + 1, y + 1));
            moves.add(new ChessMove(this, x - 1, y + 1));
        }
        return moves;
    }

    @Override
    public ArrayList<ChessMove> getAttackedSquares(ChessPiece[][] board) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        if (color == WHITE) {
            moves.add(new ChessMove(this, x + 1, y - 1));
            moves.add(new ChessMove(this, x - 1, y - 1));
        } else {
            moves.add(new ChessMove(this, x + 1, y + 1));
            moves.add(new ChessMove(this, x - 1, y + 1));
        }
        return moves;
    }
}
