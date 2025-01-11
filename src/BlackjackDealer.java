import java.util.ArrayList;

public class BlackjackDealer{
    private BlackJackPlayer player;
    private ArrayList<Card> dealerHand = new ArrayList<Card>();
    private ArrayList<Card> playerHand = new ArrayList<Card>();

    int playerChips;

    private DeckHolder decks = new DeckHolder(0);

    public BlackjackDealer(BlackjackPlayer p){this.player = p;}

    public void hitDealer(){this.dealerHand.add(decks.dealTopCard());}

    public void hitPlayer(){
        Card c = decks.dealTopCard();
        this.playerHand.add(c.clone());
        player.cards[player.numCards++] = c.clone();
    }

    public Card getVisibleCard(){
        return dealerHand.get(0);
    }

    public int cardsLeft(){
        return decks.cardsLeft();
    }

    public void playHand(){

    }
    public int handScore(){

    }

    public boolean verifyChips(){
        return player.getChips() == this.playerChips;
    }
    public int setPlayerChips(int chips){
        this.playerChips = chips;
    }


}