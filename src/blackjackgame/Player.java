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
		//this.hand.displayHand();
		System.out.println("Player's hand:");
		for (int i =0; i < hand.cardNumber(); i++) hand.displayCard(i);
	}
	
	public void takeCard(Card card){
		this.hand.takeCard(card);
	
	}
	
	public int getValueOfHand(){
		return this.hand.getValueOfHand();
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", wallet=" + wallet + ", hand=" + hand + "]";
	}
	
	
}
