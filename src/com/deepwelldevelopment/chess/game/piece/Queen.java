package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;
import java.util.Iterator;

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
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //we are attempting to capture our own piece
                }
            }
        }

        for (int x = this.x; x >= 0; x--) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //we are attempting to capture our own piece
                }
            }
        }

        for (int y = this.y; y < 8; y++) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //we are attempting to capture our own piece
                }
            }
        }

        for (int y = this.y; y >= 0; y--) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //we are attempting to capture our own piece
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
                    if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                        moves.add(new ChessMove(this, x, y));
                        break;//leave loop for this direction
                    } else {
                        break; //we are attempting to capture our own piece
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
                    if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                        moves.add(new ChessMove(this, x, y));
                        break;//leave loop for this direction
                    } else {
                        break; //we are attempting to capture our own piece
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
                    if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                        moves.add(new ChessMove(this, x, y));
                        break;//leave loop for this direction
                    } else {
                        break; //we are attempting to capture our own piece
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
                    if (ChessGame.instance.pieceAt(x, y).getColor() != color) {
                        moves.add(new ChessMove(this, x, y));
                        break;//leave loop for this direction
                    } else {
                        break; //we are attempting to capture our own piece
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
            if (!move.isLegal()) {
                iterator.remove();
            }
        }
        return moves;
    }

    @Override
    public ArrayList<ChessMove> getAttackedSquares() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        for (int x = this.x; x < 8; x++) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int x = this.x; x >= 0; x--) {
            if (ChessGame.instance.pieceAt(x, y) == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y; y < 8; y++) {
            if (ChessGame.instance.pieceAt(x, y) == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y; y >= 0; y--) {
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

    @Override
    public ArrayList<ChessMove> getAttackedSquares(ChessPiece[][] board) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        for (int x = this.x; x < 8; x++) {
            if (board[x][y] == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int x = this.x; x >= 0; x--) {
            if (board[x][y] == null || x == this.x) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y; y < 8; y++) {
            if (board[x][y] == null || y == this.y) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y; y >= 0; y--) {
            if (board[x][y] == null || y == this.y) { //there is no piece at the square we are looking at
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
