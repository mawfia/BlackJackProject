package blackjackgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    List<Card> deck = new ArrayList<>(52);
	
	public Deck() {
		for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                this.deck.add(new Card(r, s));
            }
        } 
	}

	public void displayDeck(){
	    for (Card card : this.deck) {
	            System.out.println(card);
	    }
	}
	
	public List<Card> shuffleDeck(){
	    	Collections.shuffle(this.deck);
	    	return deck;
	}
	
	public Card drawCard(){
		Card card = new Card(deck.get(0).getRank(), deck.get(0).getSuit());
		deck.remove(0);
		
		return card;
	}
	
	public Card[] drawCard(int numdraw){
		Card[] card = new Card[numdraw];
		for(int i = 0; i < numdraw; i++) card[i] = drawCard();
		return card;
	}
	
	public void addCard(Card card){
		deck.add(card);
	}
	
}
