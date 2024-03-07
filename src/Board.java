package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Board {
    private static final String boomSFX = "sfx\\boom.wav";
    private static final String winSFX = "sfx\\mariowin.wav";
    static final int ROWS=4;
    static final int COLUMNS=6;
    private static ArrayList<Card> flippedCards;
    private Timer timer;
    private Card[][] board;
    
    public Board() {
        timer = new Timer();
        flippedCards = new ArrayList<Card>();
        this.board = new Card[ROWS][COLUMNS];
        String vals[] = {
            "imgs\\arcanine.png", "imgs\\arcanine.png", "imgs\\articuno.png", "imgs\\articuno.png", "imgs\\charizard.png", "imgs\\charizard.png",
            "imgs\\dewgong.png", "imgs\\dewgong.png", "imgs\\dugtrio.png", "imgs\\dugtrio.png", "imgs\\flareon.png", "imgs\\flareon.png", 
            "imgs\\haunter.png", "imgs\\haunter.png", "imgs\\magneton.png", "imgs\\magneton.png", "imgs\\mew.png", "imgs\\mew.png",
            "imgs\\ninetales.png", "imgs\\ninetales.png", "imgs\\pikachu.png", "imgs\\pikachu.png", "imgs\\snorlax.png", "imgs\\snorlax.png"
        };
        Collections.shuffle(Arrays.asList(vals));
        for (int i=0;i<vals.length;i++) {
            this.board[i/6][i%6] = new Card(vals[i]);
        }
    }

    public Card getCard(int row, int col) {
        return board[row][col];
    }

    public void flipCard(int i, int j) {
        Card c = board[i][j];
        if (!c.isFlipped()) {
            Speaker.playSound(boomSFX);
            c.flip();
            flippedCards.add(c);
        }
    }

    public void checkForMatch() {
        if (flippedCards.size() < 2) return;
        Card c1 = flippedCards.get(0);
        Card c2 = flippedCards.get(1);

        if (!c1.getVal().equals(c2.getVal())) {
            c1.flip();
            c2.flip();
        }
        flippedCards.clear();
        for (Card[] r : board) for (Card c : r) if (!c.isFlipped()) return;

        win();
    }

    public void win() {
        timer.stopTime();
        System.out.println(timer.getTime()/1000);
        Speaker.playSound(winSFX);
        System.out.println("You Won!");
    }
}
