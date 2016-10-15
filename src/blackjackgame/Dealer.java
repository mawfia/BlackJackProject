package blackjackgame;

public class Dealer {

	Hand hand = new Hand();
	
	Dealer() {
		
	}
	
	Dealer(Card card1, Card card2){
		this.hand.takeCard(card1, card2);
	}
	
	// For dealer if showAll is zero, all cards will be displayed.
	// If showAll is  1 or greater all cards EXCEPT the first card will be shown.
	public void displayHand(int showAll){
		if (showAll > 0 && this.hand.cardNumber() > 1) System.out.println("Dealer's hand:\nCard [value=Facedown, suit=Facedown, rank=Facedown]");
		for(int i = showAll; i < this.hand.cardNumber(); i++) this.hand.displayCard(i);
	}
	
	public boolean takeCard(Card card){
		//int cardsValue = hand.getValueOfHand();
		//if(hand.getValueOfHand() > 21 && hand.cardstest.containsKey(Rank.ACE)) System.out.println("Ace value changed from 11 to 1");  //(card.getValue() == 11)) 
		if(this.hand.getValueOfHand() >= 17) return false;
		else this.hand.takeCard(card);
		
		return true;
	}
	
	public int getValueOfHand(){	
		return this.hand.getValueOfHand();
	}

}
