
public class Card {
    public enum Suit{
        Hearts, Diamonds, Clubs, Spades;
    }

    private String suit;
    private int rank;

    public Card(){
        this.suit = Suit.Spades.name();
        this.rank = 1;
    }
    public Card(String suit, int rank) {
       this.setRank(rank);
       setSuit(suit);
    }

    public int getRank(){return this.rank;}

    public String getSuit(){return this.suit;}

    private void setRank(int newRank){
        if(newRank < 1 || newRank > 13){
            return;
        }
        this.rank = newRank;
    }

    private void setSuit(String newSuit){
        this.suit = newSuit;
    }

    public String toString(){
        String rank = "";
        switch(this.rank) {
            case 1:
                rank = "Ace";
                break;
            case 11:
                rank = "Jack";
                break;
            case 12:
                rank = "Queen";
                break;
            case 13:
                rank = "King";
                break;
            default:
                rank = "" + this.rank; //number and rank the same
                break;
        }

        return rank + " of " + this.suit;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(!(o instanceof Card)){
            return false;
        }
        Card otherC = (Card)o;

        return otherC.rank == this.rank && otherC.suit == (this.suit);
    }

    public Card clone(){
        return new Card(this.suit, this.rank);
    }



}