package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private Board board;
    private JButton[][] cardButtons;

    public GUI(Board board) {
        this.board = board;

        setTitle("Concentration Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(Board.ROWS, Board.COLUMNS, 5, 5));
        cardButtons = new JButton[Board.ROWS][Board.COLUMNS];

        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLUMNS; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(100, 100));
                panel.add(button);
                cardButtons[row][col] = button;
                button.addActionListener((ActionListener) new CardButtonListener(row, col));
            }
        }

        updateUI();
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateUI() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                Card card = board.getCard(i, j);
                JButton button = cardButtons[i][j];
                if (card != null && card.isFlipped()) {
                    ImageIcon icon = new ImageIcon(card.getVal());
                    button.setIcon(icon);
                } else {
                    button.setIcon(new ImageIcon("imgs\\poke-ball.png"));
                }
            }
        }
    }

    private class CardButtonListener implements ActionListener {
        private int row;
        private int col;
        public CardButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                board.flipCard(row, col);
                updateUI();
                board.checkForMatch();
            } catch (Exception e1) {}
        }
    }
}
