import src.*;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        SwingUtilities.invokeLater(() -> new GUI(board));
    }
}
