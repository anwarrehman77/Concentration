package src;

public class Card {
    private String imgFilePath;
    private boolean flipped;

    public Card(String filePath) {
       this.imgFilePath = filePath;
       this.flipped = false;
    }
    public String getVal() {
        return imgFilePath;
    }
    public void flip() {
        flipped = !flipped;
    }
    public boolean isFlipped() {
        return flipped;
    }
    @Override
    public String toString() {
        return this.imgFilePath;
    }
}
