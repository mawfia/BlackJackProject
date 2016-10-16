package blackjackgame;
import java.util.Scanner;

public class BJTable {
	
	static Dealer dealer;
	static Deck deck;
	
	public static void main(String[] args) {

		dealCards();
	}
	
	static void BlackJackMenu(Player player){
		
		System.out.println("Please select from the menu (1-4): ");
		System.out.println("1)  Hit");
		System.out.println("2)  Stand");
		System.out.println("3)  View Hand ");
		System.out.println("4)  Surrender");
		
		Scanner input = new Scanner(System.in);
		String selection = input.next();
		switch(selection){
		case "1": System.out.println("Player takes another card."); dealCards(player, 1); break;
		case "2": System.out.println("Player holds."); dealCards(player, 0); break;
		case "3": System.out.println("Player views hand."); player.displayHand(); BlackJackMenu(player); break;
		case "4": System.out.println("Player surrenders."); break;
		default:  System.out.println("Invalid selection."); BlackJackMenu(player); break;
		}
		input.close();
	}
	
	static void dealCards(){
		deck = new Deck(); 
		deck.shuffleDeck();
		
		Player player = new Player(deck.drawCard(), deck.drawCard());
		player.displayHand();
		
		dealer = new Dealer(deck.drawCard(), deck.drawCard());
		dealer.displayHand(1);
		evaluateCards(player, 1);
	}
	
	static void dealCards(Player player, int recipient){
		
		if(recipient >= 1) { 
			player.takeCard(deck.drawCard());
			player.displayHand();
			evaluateCards(player, recipient);
		}
		else if (recipient == 0) { 
			
			if(dealer.takeCard(deck.drawCard())) {
				System.out.println("Dealer takes a card.");
				dealCards(player, 0);
			}
			else evaluateCards(player, -1);
		}
		
	}
	
	static void evaluateCards(Player player, int recipient){
		
		if((player.hand.blackjack == 0 || dealer.hand.blackjack == 0) && recipient > 0) /*System.out.print("Blackjack! ");*/  evaluateCards(player, -1);
		else if( player.getValueOfHand()*recipient*recipient > 21){
			System.out.println("Game over, player loses with: " + player.hand.cards);
		}
		else if( dealer.getValueOfHand()*recipient*recipient > 21) {
			System.out.println("Game over, dealer loses with: " + dealer.hand.cards);
		}
		else if (recipient == -1 && (dealer.getValueOfHand()*player.hand.blackjack > player.getValueOfHand()*dealer.hand.blackjack)) 
			System.out.println("Game over, dealer wins with: " + dealer.hand.cards);
		else if (recipient == -1 && (dealer.getValueOfHand()*player.hand.blackjack < player.getValueOfHand()*dealer.hand.blackjack)) 
			System.out.println("Game over, player wins with: " + player.hand.cards);
		else if (recipient == -1 && (dealer.getValueOfHand()*player.hand.blackjack == player.getValueOfHand()*dealer.hand.blackjack)) 
			System.out.println("Game over, player and dealer tie. ");
		else BlackJackMenu(player);
	
	}

}
