package blackjackgame;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
		if (showAll > 0 && this.hand.cardNumber() > 1) System.out.println("Dealer's hand:\nCard: Facedown");
		for(int i = showAll; i < this.hand.cardNumber(); i++) this.hand.displayCard(i);
		System.out.println();
	}
	
	public boolean takeCard(Card card){
//		Card aces1 = new Card (Rank.ACE, Suit.CLUBS);
//		Card aces2 = new Card (Rank.ACE, Suit.DIAMONDS);
//		Card aces3 = new Card (Rank.ACE, Suit.HEARTS);
//		Card aces4 = new Card (Rank.ACE, Suit.SPADES);
//		
//		if(hand.cards.containsKey(aces1) && hand.getValueOfHand() > 21) hand.cards.get(aces1).setValue(1);
//		if(hand.cards.containsKey(aces2) && hand.getValueOfHand() > 21) hand.cards.get(aces2).setValue(1);
//		if(hand.cards.containsKey(aces3) && hand.getValueOfHand() > 21) hand.cards.get(aces3).setValue(1);
//		if(hand.cards.containsKey(aces4) && hand.getValueOfHand() > 21) hand.cards.get(aces4).setValue(1);

		if(this.hand.getValueOfHand() >= 17) return false;
		else this.hand.takeCard(card);
		
		return true;
	}
	
	public int getValueOfHand(){	
		return this.hand.getValueOfHand();
	}
}
