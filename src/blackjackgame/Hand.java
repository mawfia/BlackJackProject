package blackjackgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Hand {

	int blackjack =  1;  // 1 means cards are not considered blackjack, 0 means cards are considered blackjack
	int split = 0;
	int gameResults = 0;
	
    List<Card> cards = new ArrayList<>(5);

	public Hand() {
	}
	
	public Hand(Card card1, Card card2){
		this.takeCard(card1, card2);
	}

	public void takeCard(Card card){
		this.cards.add(card);

		Object[] obj = cards.toArray();
		for (int i = 0; i < cards.size(); i++) if(((Card)obj[i]).getValue() == 11  && getValueOfHand() > 21) cards.get(i).setValue(1);
	}
	
	public void takeCard(Card card1, Card card2){
		this.takeCard(card1);
		this.takeCard(card2);
		
		if(card1.isBlackJackCard() && card2.isBlackJackCard() && getValueOfHand() == 21) blackjack = 0;
		else blackjack = 1;
		
		if(card1.isSplit(card1, card2)) split++;
	}
	
	public int cardNumber(){
		return this.cards.size();
	}
	
	public void displayHand(){
		for (Card card : this.cards) System.out.println(card);

	}
	
	public void displayCard(int cardNumber){
		System.out.println(this.cards.get(cardNumber));
		
	}
	
	public int getValueOfHand(){
		int total = 0;
		for(Card c: this.cards) total+= c.getValue();

		return total;
	}
	
	public void setValue(int value) {
		setValue(value);
	}

	
}
