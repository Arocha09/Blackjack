import java.util.ArrayList;

public class Deck {
    private Card[] deck;
    private int top = 0;



    public Deck() {
        deck = new Card[52];

        int i = 0;
        for(int r = 1; r <= 13; r++) {
            for(Card.Suit s : Card.Suit.values()) {
                deck[i] = new Card(s.name(), r);
                i++;
            }
        }

        shuffle();
    }

    public void shuffle() {
        for(int i = 0; i < deck.length-1; i++) {
            int r = (int)(Math.random()*(52-i))+i;

            Card temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }
    public int cardsLeft(){
        return deck.length - top;
    }

    public Card dealTopCard(){
        if(top >= deck.length){
            restockDeck();
        }
        top++;
        return deck[top - 1];
    }

    public void restockDeck() {
        shuffle();
        top = 0;
    }
}