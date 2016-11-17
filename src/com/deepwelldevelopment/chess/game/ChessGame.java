package com.deepwelldevelopment.chess.game;

import com.deepwelldevelopment.chess.game.piece.*;

import java.util.ArrayList;

public class ChessGame {

    public static ChessGame instance;


    ChessPiece[][] board;

    public ChessGame() {
        board = new ChessPiece[8][8];

        //black pieces
        for (int i = 0; i < 8; i++) {
            //board[i][1] = new Pawn(ChessPiece.BLACK, i, 1);
        }
        board[0][0] = new Rook(ChessPiece.BLACK, 0, 0);
        board[1][0] = new Knight(ChessPiece.BLACK, 1, 0);
        board[2][0] = new Bishop(ChessPiece.BLACK, 2, 0);
        board[3][0] = new Queen(ChessPiece.BLACK, 3, 0);
        board[4][0] = new King(ChessPiece.BLACK, 4, 0);
        board[5][0] = new Bishop(ChessPiece.BLACK, 5, 0);
        board[6][0] = new Knight(ChessPiece.BLACK, 6, 0);
        board[7][0] = new Rook(ChessPiece.BLACK, 7, 0);

        //white pieces
        for (int i = 0; i < 8; i++) {
            //board[i][6] = new Pawn(ChessPiece.WHITE, i, 6);
        }
        board[0][7] = new Rook(ChessPiece.WHITE, 0, 7);
        board[1][7] = new Knight(ChessPiece.WHITE, 1, 7);
        board[2][7] = new Bishop(ChessPiece.WHITE, 2, 7);
        board[3][7] = new Queen(ChessPiece.WHITE, 3, 7);
        board[4][7] = new King(ChessPiece.WHITE, 4, 7);
        board[5][7] = new Bishop(ChessPiece.WHITE, 5, 7);
        board[6][7] = new Knight(ChessPiece.WHITE, 6, 7);
        board[7][7] = new Rook(ChessPiece.WHITE, 7, 7);

        instance = this;
    }

    public ChessPiece pieceAt(int x, int y) {
        return board[x][y];
    }

    public void putPiece(ChessPiece piece, int x, int y) {
        board[x][y] = piece;
    }

    public void removePiece(int x, int y) {
        board[x][y] = null;
    }

    public boolean canKingMoveTo(int color, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null) {
                    if (piece.getType() != ChessPiece.KING) {
                        ArrayList<ChessMove> moves = piece.getAttackedSquares();
                        for (ChessMove move : moves) {
                            if (move.getPiece().getColor() != color) { //opposing piece
                                //check if piece is attacking target square for this move
                                if (move.getTargetX() == x && move.getTargetY() == y) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true; //if this is reached, was not returned for any of opponents pieces
    }
}
