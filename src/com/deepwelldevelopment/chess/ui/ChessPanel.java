package com.deepwelldevelopment.chess.ui;

import com.deepwelldevelopment.chess.game.ChessGame;
import com.deepwelldevelopment.chess.game.ChessMove;
import com.deepwelldevelopment.chess.game.piece.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ChessPanel extends JPanel implements Runnable, MouseListener {

    Thread thread = new Thread(this);

    int width;
    int height;
    int squareWidth;
    int squareHeight;

    //-1 indicate no selection
    int selectedX = -1;
    int selectedY = -1;

    boolean first;

    Color highlightColor;

    public ChessPanel(ChessFrame frame) {
        frame.addMouseListener(this);

        highlightColor = new Color(62, 255, 119, 150);

        first = true;
        thread.start();

        new ChessGame();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //first time initialization
        if (first) {
            width = getWidth();
            height = getHeight();
            squareWidth = width/8;
            squareHeight = height/8;
            first = false;
        }

        //draw board
        int color = 0;
        for (int  x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (color == 0) {
                    g.setColor(Color.WHITE);
                    color = 1;
                } else if (color == 1) {
                    g.setColor(Color.BLACK);
                    color = 0;
                }
                g.fillRect(x*squareWidth, y*squareHeight, squareWidth, squareHeight);
            }
            if (color == 0) {
                g.setColor(Color.WHITE);
                color = 1;
            } else if (color == 1) {
                g.setColor(Color.BLACK);
                color = 0;
            }
        }

        //draw pieces
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 72));
        g.setColor(Color.ORANGE);
        FontMetrics fm = g.getFontMetrics();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessPiece piece = ChessGame.instance.pieceAt(x, y);
                if (piece != null) {
                    switch (piece.getType()) { //identify piece type
                        case ChessPiece.PAWN:
                            g.drawString("P", (x * squareWidth), (y * squareHeight) + 60);
                            break;
                        case ChessPiece.KNIGHT:
                            g.drawString("N", (x * squareWidth), (y * squareHeight) + 60);
                            break;
                        case ChessPiece.BISHOP:
                            g.drawString("B", (x * squareWidth), (y * squareHeight) + 60);
                            break;
                        case ChessPiece.ROOK:
                            g.drawString("R", (x*squareWidth), (y*squareHeight) + 60);
                            break;
                        case ChessPiece.QUEEN:
                            g.drawString("Q", (x * squareWidth), (y * squareHeight) + 60);
                            break;
                        case ChessPiece.KING:
                            g.drawString("K", (x * squareWidth), (y * squareHeight) + 60);
                            break;
                        default: //should never be seen
                            break;
                    }
                }
            }
        }

        //highlight selected square
        if (selectedX != -1 && selectedY != -1) {
            int x = selectedX*squareWidth;
            int y = selectedY*squareHeight;

            g.setColor(highlightColor);
            g.fillRect(x, y, squareWidth, squareHeight);

            //fill in squares for legal moves of selected piece
            ChessPiece piece = ChessGame.instance.pieceAt(selectedX, selectedY);
            ArrayList<ChessMove> moves = piece.getValidMoves();
            for (ChessMove move : moves) {
                int moveX = move.getTargetX();
                int moveY = move.getTargetY();
                g.fillRect(moveX*squareWidth, moveY*squareHeight, squareWidth, squareHeight);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            revalidate();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (selectedX == -1 && selectedY == -1) {
            //find grid location for mouse click
            int x = e.getX() / squareWidth;
            int y = (e.getY()-30) / squareHeight;

            //if there is apiece in the selected square, select the square
            if (ChessGame.instance.pieceAt(x, y) != null) {
                selectedX = x;
                selectedY = y;
                return;
            } else { //otherwise deselect the selected square
                selectedX = -1;
                selectedY = -1;
                return;
            }
        } else { //there is a piece already selected, attempt to move it
            int x = e.getX() / squareWidth;
            int y = (e.getY()-30) / squareHeight;
            ChessMove move = new ChessMove(ChessGame.instance.pieceAt(selectedX, selectedY), x, y);
            if (ChessGame.instance.isNewBoardLegal(ChessGame.instance.pseudoMove(move))) {
                move.move();
                ChessGame.instance.parseBoardState();
                selectedX = -1;
                selectedY = -1;
                return;
            }
        }

        int x = e.getX() / squareWidth;
        int y = (e.getY() - 30) / squareHeight;
        if (ChessGame.instance.pieceAt(x, y) != null) {
            if (ChessGame.instance.pieceAt(x, y).getColor() == ChessGame.instance.getTurn()) {
                selectedX = x;
                selectedY = y;
            } else {
                selectedX = -1;
                selectedY = -1;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
