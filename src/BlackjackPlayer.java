public abstract class BlackjackPlayer {

    private int chips = 1000;

    protected Card[] cards = new Card[22];
    protected int numCards;

    public BlackjackDealer dealer;

    public abstract int getBet();
    public abstract Move getMove();
    public abstract void handOver(Card[] dealerHand);

    public int getChips(){return chips;}

    public void giveChips(int numChips){this.chips += numChips;}

    public void takeChips(int numChips){this.chips -= numChips;}

    public int handScore(){
        int totalScore = 0;
        int numAces = 0;
        Card c;
        for(int i = 0; i < numCards; i++){
            c = cards[i];
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

    public void setDealer(BlackjackDealer dealer){
        this.dealer = dealer;
        dealer.setPlayerChips(chips);
    }

}