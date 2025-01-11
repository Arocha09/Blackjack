
public class Card {
    private String suit;
    private int value;
    private int rank;

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Card clone(){
        return new Card(suit, value);
    }

    public String getRank(){}


}