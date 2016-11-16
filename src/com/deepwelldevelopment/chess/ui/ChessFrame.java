package com.deepwelldevelopment.chess.ui;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {

    public ChessFrame() {
        setTitle("Chess");
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(new ChessPanel(this));
        setVisible(true);
    }
}
