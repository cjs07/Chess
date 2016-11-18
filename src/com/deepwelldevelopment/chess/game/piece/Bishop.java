package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;
import java.util.Iterator;

public class Bishop extends ChessPiece {

    public Bishop(int color,  int x, int y) {
        super(color, BISHOP, x, y);
    }

    @Override
    public ArrayList<ChessMove> getValidMoves() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        int targetX;
        int targetY;
        try {
            for (int i = 1; i < 8; i++) {
                targetX = x + i;
                targetY = y + i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else { //there is a piece at the target square
                    if (ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                        moves.add(new ChessMove(this, targetX, targetY));
                        break;
                    } else {
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        try {
            for (int i = 1; i < 8; i++) {
                targetX = x - i;
                targetY = y + i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    if (ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                        moves.add(new ChessMove(this, targetX, targetY));
                        break;
                    } else {
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        try {
            for (int i = 1; i < 8; i++) {
                targetX = x - i;
                targetY = y - i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    if (ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                        moves.add(new ChessMove(this, targetX, targetY));
                        break;
                    } else {
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        try {
            for (int i = 1; i < 8; i++) {
                targetX = x + i;
                targetY = y - i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    if (ChessGame.instance.pieceAt(targetX, targetY).getColor() != color) {
                        moves.add(new ChessMove(this, targetX, targetY));
                        break;
                    } else {
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        //remove moves that would cause a check, or do not save a king from check
        Iterator<ChessMove> iterator = moves.iterator();
        while (iterator.hasNext()) {
            ChessMove move = iterator.next();
            if (!ChessGame.instance.isNewBoardLegal(ChessGame.instance.pseudoMove(move))) {
                iterator.remove();
            }
        }

        return moves;
    }

    @Override
    public ArrayList<ChessMove> getAttackedSquares() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        int targetX;
        int targetY;
        try {
            for (int i = 1; i < 8; i++) {
                targetX = x + i;
                targetY = y + i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else { //there is a piece at the target square
                    moves.add(new ChessMove(this, targetX, targetY));
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        try {
            for (int i = 1; i < 8; i++) {
                targetX = x - i;
                targetY = y + i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    moves.add(new ChessMove(this, targetX, targetY));
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        try {
            for (int i = 1; i < 8; i++) {
                targetX = x - i;
                targetY = y - i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    moves.add(new ChessMove(this, targetX, targetY));
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }

        try {
            for (int i = 1; i < 8; i++) {
                targetX = x + i;
                targetY = y - i;
                if (ChessGame.instance.pieceAt(targetX, targetY) == null) {
                    moves.add(new ChessMove(this, targetX, targetY));
                } else {
                    moves.add(new ChessMove(this, targetX, targetY));
                    break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }
        return moves;
    }
}
