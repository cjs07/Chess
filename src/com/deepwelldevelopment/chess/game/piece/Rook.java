package com.deepwelldevelopment.chess.game.piece;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;

import java.util.ArrayList;
import java.util.Iterator;

public class Rook extends ChessPiece {

    public Rook(int color, int x, int y) {
        super(color, ROOK, x, y);
    }

    @Override
    public ArrayList<ChessMove> getValidMoves() {
        ArrayList<ChessMove> moves = new ArrayList<>();

        //check all squares that the piece could move to
        for (int x = this.x + 1; x < 8; x++) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
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

        for (int x = this.x - 1; x >= 0; x--) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
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

        for (int y = this.y + 1; y < 8; y++) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this,x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                if (ChessGame.instance.pieceAt(x, y).getColor() != color) { //piece in target square is opposing color and can be captured
                    moves.add(new ChessMove(this, x, y));
                    break;//leave loop for this direction
                } else {
                    break; //leave the loop for this direction
                }
            }
        }

        for (int y = this.y - 1; y >= 0; y--) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
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

        //check all squares that the piece could move to
        for (int x = this.x + 1; x < 8; x++) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int x = this.x - 1; x >= 0; x--) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y + 1; y < 8; y++) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y - 1; y >= 0; y--) {
            if (ChessGame.instance.pieceAt(x, y) == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }
        return moves;
    }

    @Override
    public ArrayList<ChessMove> getAttackedSquares(ChessPiece[][] board) {
        ArrayList<ChessMove> moves = new ArrayList<>();

        //check all squares that the piece could move to
        for (int x = this.x + 1; x < 8; x++) {
            if (board[x][y] == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int x = this.x - 1; x >= 0; x--) {
            if (board[x][y] == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y + 1; y < 8; y++) {
            if (board[x][y] == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }

        for (int y = this.y - 1; y >= 0; y--) {
            if (board[x][y] == null) { //there is no piece at the square we are looking at
                moves.add(new ChessMove(this, x, y));
            } else { //there is a piece at the target square. no more moves can be made past this square in this direction (except the knight)
                moves.add(new ChessMove(this, x, y));
                break;//leave loop for this direction
            }
        }
        return moves;
    }
}
