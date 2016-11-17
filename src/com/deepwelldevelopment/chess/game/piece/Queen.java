package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;

public class Queen extends ChessPiece {

    public Queen(int color, int x, int y) {
        super(color, QUEEN, x, y);
    }

    @Override
    public ArrayList<ChessMove> getValidMoves() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        for (int x = this.x; x < 8; x++) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) { //piece in target square is opposing color and can be captured
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //leave the loop for this direction
                }
            }
        }

        for (int x = this.x; x >= 0; x--) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) { //piece in target square is opposing color and can be captured
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //leave the loop for this direction
                }
            }
        }

        for (int y = this.y; y < 8; y++) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) { //piece in target square is opposing color and can be captured
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //leave the loop for this direction
                }
            }
        }

        for (int y = this.y; y >= 0; y--) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) { //piece in target square is opposing color and can be captured
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //leave the loop for this direction
                }
            }
        }

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
        return moves;
    }

    @Override
    public ArrayList<ChessMove> getAttackedSquares() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        for (int x = this.x + 1; x < 8; x++) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int x = this.x - 1; x >= 0; x--) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y + 1; y < 8; y++) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y - 1; y >= 0; y--) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

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
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            //off the board
        }
        return moves;
    }
}
