package ttt.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTTGUI extends JFrame {
    private GameManager gameManager;
    private JButton[][] buttons;
    public TTTGUI(){
        gameManager = new GameManager();
        buttons = new JButton[3][3];
        gameManager.reset();
        init();

    }

    private void init(){
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        setLayout(new GridLayout(3,3));

        ActionListener listener = e -> {
            JButton button = (JButton) e.getSource();
            int row = -1, col = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (button == buttons[i][j]) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }

            if(row != -1 && col != -1 && gameManager.isPlaced(row,col)){
                button.setText(String.valueOf(gameManager.getCurrentPlayer()));
                if(gameManager.checkWin()){
                    JOptionPane.showMessageDialog(TTTGUI.this, "Player " + gameManager.getCurrentPlayer() + " wins!");
                    resetBoard();
                }else if(gameManager.checkDraw()){
                    JOptionPane.showMessageDialog(TTTGUI.this, "It's a draw!");
                    resetBoard();
                }else {
                    gameManager.next();
                }
            }else {
                JOptionPane.showMessageDialog(TTTGUI.this,"This slot has already been placed by players.");
            }

        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 48));
                buttons[i][j].addActionListener(listener);
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }

    private void resetBoard() {
        gameManager.reset();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
    }

