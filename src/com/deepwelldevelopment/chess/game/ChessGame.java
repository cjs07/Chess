package com.deepwelldevelopment.chess.game;

import com.deepwelldevelopment.chess.game.piece.*;

import java.util.ArrayList;

public class ChessGame {

    public static ChessGame instance;


    ChessPiece[][] board;

    int turn;

    boolean whiteCheck;
    boolean blackCheck;

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

        whiteCheck = false;
        blackCheck = false;

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

    //checks if square is attacked, color parameter is the color that posses the square
    public boolean isSquareAttacked(int color, int x, int y) {
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
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //essentially an update loop
    public void parseBoardState() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                ChessPiece piece = board[x][y];
                if (piece != null) {
                    if (piece.getType() == ChessPiece.KING) {
                        if (isSquareAttacked(piece.getColor(), x, y)) {
                            if (piece.getColor() == ChessPiece.WHITE) {
                                whiteCheck = true;
                                System.out.println("White is in check");
                            } else {
                                blackCheck = true;
                                System.out.println("Black is in check");
                            }
                        }
                    }
                }
            }
        }

        //switch turn
        if (turn == ChessPiece.WHITE) {
            turn = ChessPiece.BLACK;
        } else {
            turn = ChessPiece.WHITE;
        }
    }

    public boolean isNewBoardLegal(ChessPiece[][] board) {
        //find the kings
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                ChessPiece piece = board[x][y];
                if (piece != null) {
                    if (piece.getType() == ChessPiece.KING) {
                        if (isSquareAttacked(piece.getColor(), piece.getX(), piece.getY())) {
                            if (piece.getColor() == ChessPiece.WHITE) {
                                if (turn == ChessPiece.WHITE) {
                                    return false;
                                }
                            } else {
                                if (turn == ChessPiece.BLACK) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    //returns a new representation of a board without changing the actual board
    //used for testing moves for discovered checks, pins, etc.
    public ChessPiece[][] pseudoMove(ChessPiece piece, int x, int y) {
        ChessPiece[][] pseudo = new ChessPiece[8][8];
        for (int i = 0; i < pseudo.length; i++) {
            for (int j = 0; j < pseudo[0].length; j++) {
                pseudo[i][j] = board[i][j];
            }
        }
        int oldX = piece.getX();
        int oldY = piece.getY();
        pseudo[x][y] = piece;
        pseudo[oldX][oldY] = null;
        return pseudo;
    }

    //returns a new representation of a board without changing the actual board
    //used for testing moves for discovered checks, pins, etc.
    public ChessPiece[][] pseudoMove(ChessMove move) {
        ChessPiece[][] pseudo = new ChessPiece[8][8];
        for (int x = 0; x < pseudo.length; x++) {
            for (int y = 0; y < pseudo[0].length; y++) {
                pseudo[x][y] = board[x][y];
            }
        }
        ChessPiece piece = move.getPiece();
        int x = move.getTargetX();
        int y = move.getTargetY();
        int oldX = piece.getX();
        int oldY = piece.getY();
        pseudo[x][y] = null;
        pseudo[x][y] = piece;
        pseudo[oldX][oldY] = null;
        return pseudo;
    }

    public int getTurn() {
        return turn;
    }
}
