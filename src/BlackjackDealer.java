import java.util.ArrayList;

public class BlackjackDealer{
    private BlackJackPlayer player;
    private ArrayList<Card> dealerHand = new ArrayList<Card>();
    private ArrayList<Card> playerHand = new ArrayList<Card>();

    int playerChips;

    private DeckHolder decks = new DeckHolder(0);

    public BlackjackDealer(BlackjackPlayer p){this.player = p;}


}