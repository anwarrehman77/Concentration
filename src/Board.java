package src;
import java.util.Arrays;
import java.util.Collections;

public class Board {
    static Card c1=null;
    static Card c2=null;
    static final int ROWS=4;
    static final int COLUMNS=6;
    private Card[][] board;
    
    public Board() {
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
        board[i][j].flip();
    }
}
