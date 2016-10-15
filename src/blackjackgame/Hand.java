package blackjackgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class Hand {

    List<Card> cards = new ArrayList<>(12);
    //Map<Card, Card> cardstest = new HashMap<>(12);

	public Hand() {
	}
	
	public Hand(Card card1, Card card2){
		this.takeCard(card1, card2);
	}
	
	public void takeCard(Card card){
		this.cards.add(card);
		//this.cardstest.put(card, card);
	
	}
	
	public void takeCard(Card card1, Card card2){
		this.takeCard(card1);
		this.takeCard(card2);
		
	}
	
	public int cardNumber(){
		return cards.size();
		//return cardstest.size();
	}
	
	public void displayHand(){
		for (Card card : this.cards) System.out.println(card);
		//for (Rank key : cardstest.keySet()) System.out.println(cardstest.get(key));

	}
	
	public void displayCard(int cardNumber){
		System.out.println(this.cards.get(cardNumber));
		//System.out.println(this.cardstest.keySet().toArray()[cardNumber]);
		
	}
	
	public int getValueOfHand(){
		int total = 0;
		for(Card c: this.cards) total+= c.getValue();
		
		return total;
	}
	
	public void setValue(int value, int card) {
		//cardstest.put(key, value)
		//deck.get(card).setValue(value);
	}

	@Override
	public String toString() {
		return  cards + "]";
	}
	
	
}
