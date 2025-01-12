
public class MyBlackjackPlayer extends BlackjackPlayer{
    @Override
    public int getBet(){return 10;}

    @Override
    public Move getMove(){
        if(this.handScore() <= 16) return Move.HIT;
        return Move.STAY;
    }



    @Override
    public void handOver(Card[] dealerHand){
        int value = 0;
        for(int i = 0; i<dealerHand.length; i++){
            value += dealerHand[i].getRank();
        }
    }
}