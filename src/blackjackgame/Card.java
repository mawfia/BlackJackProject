package blackjackgame;


public class Card {

	private int value;
	private Suit suit;
	private Rank rank;
	
	Card(){
		this(null, null);
		this.setValue(0);
	}
	
	public Card(Rank rank, Suit suit) {
		this.setSuit(suit);
		this.setRank(rank);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	Suit getSuit() {
		return this.suit;
	}

	private void setSuit(Suit suit) {
		this.suit = suit;
	}

	Rank getRank() {
		return rank;
	}

	 void setRank(Rank rank) {
		
		switch(this.rank = rank){
		case TWO: this.value = 2; break;
		case THREE: this.value = 3; break;
		case FOUR: this.value = 4; break;
		case FIVE: this.value = 5; break;
		case SIX: this.value = 6; break;
		case SEVEN: this.value = 7; break;
		case EIGHT: this.value = 8; break;
		case NINE: this.value = 9; break;
		case TEN: 
		case JACK:
		case QUEEN:
		case KING: this.value = 10; break;
		case ACE: this.value = 11; break;
		default: break;
		}
	}
	 
	boolean isBlackJackCard(){
		
		switch(this.rank){
		case ACE: case KING: case QUEEN: case JACK: return true;
		default: return false;
		}
	}
	
	boolean isSplit(Card card1, Card card2){
		if(card1.getValue() == card2.getValue()) return true;
		else return false;
	}

	@Override
	public String toString() {
		return  rank + " of " + suit;
//				"Card [value=" + value + ", suit=" + suit + ", rank=" + rank + "]";
	}

}
