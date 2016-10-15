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
		setSuit(suit);
		setRank(rank);
	}

	public int getValue() {
		return value;
	}

	void setValue(int value) {
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

	@Override
	public String toString() {
		return  "Card [value=" + value + ", suit=" + suit + ", rank=" + rank + "]";
	}
}
