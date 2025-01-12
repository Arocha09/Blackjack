import java.util.ArrayList;

public class DeckHolder {
   private Deck[] decks;
   int count = 0;
   int deckNum = 0;
   int cards = 0;


    public DeckHolder(int numDecks) {
        decks = new Deck[numDecks];
        for(int i = 0; i < numDecks; i++) {
            decks[i] = new Deck();
        }

    }

    public Card dealTopCard(){
        if (count == 52){
            deckNum += 1;
        }
        count++;

        if(deckNum >= decks.length){
            restoreDecks();
        }
        return decks[deckNum].dealTopCard();
    }

    public void restoreDecks(){
        for(int i = 0; i < decks.length; i++){
            decks[i].shuffle();
        }
        count = 0;
        deckNum = 0;
    }
    public int cardsLeft(){
        int cards = 0;
        for(int i = 0; i < decks.length; i++){
            cards += decks[i].cardsLeft();
        }
        return cards;
    }

}