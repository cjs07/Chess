package com.deepwelldevelopment.chess.game;

import com.deepwelldevelopment.chess.game.piece.ChessPiece;
import com.deepwelldevelopment.chess.game.piece.Rook;

public class ChessGame {

    public static ChessGame instance;


    ChessPiece[][] board;

    public ChessGame() {
        board = new ChessPiece[8][8];

        //black pieces
        board[0][0] = new Rook(ChessPiece.BLACK, 0, 0);
        board[7][0] = new Rook(ChessPiece.BLACK, 7, 0);

        //white pieces
        board[0][7] = new Rook(ChessPiece.WHITE, 0, 7);
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
}
