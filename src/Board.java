package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board extends JFrame {
    private final int rows;
    private final int cols;
    private final List<CardButton> buttons;
    private final List<Character> cardValues;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        buttons = new ArrayList<>();
        cardValues = new ArrayList<>();
        initializeCardValues();
        initializeGUI();
    }

    private void initializeCardValues() {
        int pairs = rows * cols / 2;
        char currentChar = 'A'; // Starting character for card values
        for (int i = 0; i < pairs; i++) {
            cardValues.add(currentChar);
            cardValues.add(currentChar);
            currentChar++;
        }
        Collections.shuffle(cardValues);
    }

    private void initializeGUI() {
        setTitle("Concentration Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(rows, cols));

        for (int i = 0; i < rows * cols; i++) {
            CardButton button = new CardButton(i);
            buttons.add(button);
            add(button);
        }

        setSize(400, 400);
        setVisible(true);
    }

    private class CardButton extends JButton {
        private final int index;
        private boolean flipped;
        private char value;

        public CardButton(int index) {
            this.index = index;
            this.flipped = false;
            this.value = cardValues.get(index);
            setPreferredSize(new Dimension(50, 50));

            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!flipped) {
                        flip();
                        checkForMatch();
                    }
                }
            });
        }

        public void flip() {
            if (!flipped) {
                flipped = true;
                setText(String.valueOf(value));
            } else {
                flipped = false;
                setText("");
            }
        }

        private void checkForMatch() {
            List<CardButton> flippedCards = new ArrayList<>();
            for (CardButton button : buttons) {
                if (button.flipped && !button.equals(this)) {
                    flippedCards.add(button);
                }
            }
            if (flippedCards.size() == 2) {
                if (flippedCards.get(0).value == flippedCards.get(1).value) {
                    flippedCards.get(0).setEnabled(false);
                    flippedCards.get(1).setEnabled(false);
                } else {
                    flippedCards.get(0).flip();
                    flippedCards.get(1).flip();
                }
            }
        }        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Board(4, 4);
        });
    }
}
