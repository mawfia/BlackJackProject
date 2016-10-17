package blackjackgame;

public class Player {

	private String name;
	private int wallet;
	Hand hand = new Hand();
	
	Player() {
		
	}
	
	Player(Card card1, Card card2){
		this.hand.takeCard(card1, card2);
	}
	
	public void displayHand(){
		System.out.println("Player's hand:");
		for (int i =0; i < hand.cardNumber(); i++) hand.displayCard(i);
		System.out.println();
	}
	
	public void takeCard(Card card){
		this.hand.takeCard(card);
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getValueOfHand(){
		return this.hand.getValueOfHand();
	}
	
//	public void setAceValue(){
//		Card aces1 = new Card (Rank.ACE, Suit.CLUBS);
//		Card aces2 = new Card (Rank.ACE, Suit.DIAMONDS);
//		Card aces3 = new Card (Rank.ACE, Suit.HEARTS);
//		Card aces4 = new Card (Rank.ACE, Suit.SPADES);
//		
//		if(hand.cards.containsKey(aces1) && hand.getValueOfHand() > 21) hand.cards.get(aces1).setValue(1);
//		if(hand.cards.containsKey(aces2) && hand.getValueOfHand() > 21) hand.cards.get(aces2).setValue(1);
//		if(hand.cards.containsKey(aces3) && hand.getValueOfHand() > 21) hand.cards.get(aces3).setValue(1);
//		if(hand.cards.containsKey(aces4) && hand.getValueOfHand() > 21) hand.cards.get(aces4).setValue(1);
//	}

	
}
