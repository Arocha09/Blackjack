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
        this.player.cards = new Card[this.player.cards.length()];
        this.player.numCards = 0;
        this.dealerHand.clear();
        this.playerHand.clear();

        if(decks.cardsLeeft() < 18){
            decks.restoreDecks();
        }

        int bet = player.getBet();

        player.takeChips(bet);

        playerChips -= bet;

        hitDealer();
        hitPlayer();
        hitDealer();
        hitPlayer();

        Move playerMove = player.getMove();
        while(playerMove != Move.STAY && handScore(this.playerHand)<21){
            if(playerMove == Move.HIT){
                hitPlayer();
            }else if(playerMove == Move.DOUBLE){
                player.takeChips(bet);
                playerChips -= bet;
                bet *= 2;
                hitPlayer();
                break;
            }

            playerMove = player.getMove();

        }

        while(handscore(this.dealerHand) < 17){
            hitDealer();
        }

        int dealerScore = handscore(this.dealerHand);
        int playerScore = handScore(this.playerHand);

        System.out.println("END OF ROUND # " + handNum);
        System.out.println("___________________________");
        System.out.println("Player Chips Before: " + (this.player.getChips() + bet));

        int win = 0;
        if(dealerScore == 21 && this.dealerHand.size() == 2){
            ;
        }else if(playerScore > 21){
            ;
        }else if(dealerScore > 21){
            win = bet*2;
        }else if(playerScore == 21 && this.playerHand.size() == 2){
            win = bet + ((int) (bet * 1.5));
        }else if(playerScore > dealerScore){
            win = bet*2;
        }else if(dealerScore == playerScore){
            win = bet;
        }
        player.giveChips(win);
        playerChips += win;

        if(!verifyChips()){
            System.out.println(
                    "FATAL ERROR: Chip count doesn't match, player is trying to manipulate their chip amount!!!");
            System.exit(3);
        }

        System.out.println("Dealer Hand: " + this.dealerHand);
        System.out.println("Dealer Score: " + d + "\n");
        System.out.println("Player Hand: " + this.playerHand);
        System.out.println("Player Score: " + p);
        System.out.println("Player Chips After: " + (this.player.getChips()) + "\n");

        Card[] dHand = new Card[this.dealerHand.size()];
        for (int i = 0; i < this.dealerHand.size(); i++)
            dHand[i] = this.dealerHand.get(i).clone();
        this.player.handOver(dHand);
    }
    public int handScore(ArrayList<Card> cards){
        int totalScore = 0;
        int numAces = 0;
        Card c;
        for(int i = 0; i < cards.length; i++){
            c = Cards[i];
            int rank = c.getRank();
            if (rank > 10){
                rank = 10;
            }
            if (rank == 1){
                numAces++;
                rank = 11;
            }
            totalScore += rank;
        }
        while(totalScore > 21 && numAces > 0){
            totalScore -= 10;
            numAces--;
        }
        return totalScore;
    }

    public boolean verifyChips(){
        return player.getChips() == this.playerChips;
    }
    public int setPlayerChips(int chips){
        this.playerChips = chips;
    }


}