package blackjackgame;
import java.util.Scanner;

public class BJTable {
	
	static Dealer dealer;
	static Deck deck;
	
	public static void main(String[] args) {

		dealCards();
	}
	
	static Hand BlackJackMenu(Player player){
		
		System.out.println("Please select from the menu (1-4): ");
		System.out.println("1)  Hit");
		System.out.println("2)  Stand");
		System.out.println("3)  View Hand ");
		System.out.println("4)  Surrender");
		
		Scanner input = new Scanner(System.in);
		String selection = input.next();
		switch(selection){
		case "1": System.out.println("Player takes another card."); player.hand = dealCards(player, 1); break;
		case "2": System.out.println("Player holds."); if(player.hand.split < 0) break; else { player.hand = dealCards(player, 0); break; }
		case "3": System.out.println("Player views hand."); player.displayHand(); player.hand = BlackJackMenu(player); break;
		case "4": System.out.println("Player surrenders."); player.hand.gameResults = 6; if(player.hand.split == 1) displayResults(player); break;  
		default:  System.out.println("Invalid selection."); player.hand = BlackJackMenu(player); break;
		}
		
		if(player.hand.split < 0) return player.hand;
		
		return player.hand;
	}
	
	static void dealCards(){ // For initial draw of cards for player and dealer
		deck = new Deck(); 
		deck.shuffleDeck();
		
		Scanner input = new Scanner(System.in);
		
		Player player = new Player(deck.drawCard(), deck.drawCard());
		System.out.println("Please enter your name: ");
		player.setName(input.next());
		player.displayHand();
		
		dealer = new Dealer(deck.drawCard(), deck.drawCard());
		dealer.displayHand(1);
		evaluateCards(player, 1);
		
		input.close();
	}
	
	static Hand dealCards(Player player, int recipient){ // For subsequent draws for both player and dealer
		
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
			else { System.out.println("Dealer holds. \n"); evaluateCards(player, -1); }
		}
		
		return player.hand;
	}
	
	static Hand dealCards(Player player){  // For split game
		Hand split1 = new Hand(player.hand.cards.get(0), deck.drawCard());
		Hand split2 = new Hand(player.hand.cards.get(1), deck.drawCard());
		
		System.out.println("***" + player.getName() + " has a split hand!***\n");
		Player splayer = new Player();
		
		splayer.setName(player.getName());
		System.out.println("Split 1 Play");
		splayer.hand = split1;
		splayer.hand.split = -player.hand.split*(1-(2*split1.split));  // Check to see if there is another split for the first hand
		splayer.displayHand();
		split1 = evaluateCards(splayer, 1);
		
		System.out.println("\nSplit 2 Play");
		splayer.hand = split2;
		splayer.hand.split = -player.hand.split*(1-(2*split2.split));  // Check to see if there is another split for the second hand
		splayer.displayHand();
		split2 = evaluateCards(splayer, 1);
		
		// Dealers turn after both splits are done with drawing cards
		// Determine if win or loss on split's first hand
		splayer.hand = split1;
		splayer.hand.split = -1; // Resave flag indicating this is the dealer's turn on a first hand for a split
		split1 = dealCards(splayer, 0);
		
		// Determine if win or loss on split's second hand
		splayer.hand = split2;
		splayer.hand.split = -1; // Resave flag indicating this is the dealer's turn on a second hand for a split
		split2 = dealCards(splayer, 0);
		
		// Display results of split's first hand
		player.hand = split1;
		player.hand.split = 1;
		player.setName(player.getName() + "'s first hand of split results.");
		displayResults(player);
		
		// Display results of split's second hand
		player.hand = split2;
		player.hand.split = 1;
		player.setName(splayer.getName() + "'s second hand of split results.");
		displayResults(player);
		
		return player.hand;
	}
	
	static Hand evaluateCards(Player player, int recipient){
		
		if(player.hand.split >= 1) player.hand = dealCards(player);
		else if((player.hand.blackjack == 0 || dealer.hand.blackjack == 0) && recipient > 0) 
		{ 
			if(player.hand.split < 0) player.hand.blackjack = 1;/*System.out.print("Blackjack! ");*/  player.hand = evaluateCards(player, -1); 
		}	// Blackjacks after a split are considered non-blackjack 21 when comparing against the dealer's hand.
		else if( player.getValueOfHand()*recipient*recipient > 21) { player.hand.gameResults = 1; displayResults(player); }
		else if( dealer.getValueOfHand()*recipient*recipient > 21) { player.hand.gameResults = 7; displayResults(player); }
		else if (recipient == -1 && (dealer.getValueOfHand()*player.hand.blackjack > player.getValueOfHand()*dealer.hand.blackjack)) 
		{ 
			player.hand.gameResults = 8; displayResults(player); 
		}
		else if (recipient == -1 && (dealer.getValueOfHand()*player.hand.blackjack < player.getValueOfHand()*dealer.hand.blackjack)) 
		{	
			player.hand.gameResults = 2; displayResults(player);
		}
		else if (recipient == -1 && (dealer.getValueOfHand()*player.hand.blackjack == player.getValueOfHand()*dealer.hand.blackjack)) 
		{
			player.hand.gameResults = 4; displayResults(player);
		}
		else player.hand = BlackJackMenu(player);
	
		return player.hand;
	}
	
	static void displayResults(Player player){
		
		if(player.hand.split == 0){ // Results for non split games
			System.out.println(player.getName() + "'s summary: ");
			System.out.println("_______________________________");
			switch(player.hand.gameResults){
				case 0: break;  // default setting
				case 1: System.out.println("Game over, player loses with: " + player.hand.cards); break;// player loses
				case 2: if(player.hand.blackjack == 0) System.out.println("Game over, player wins with Blackjack: " + player.hand.cards); // player wins without black jack 
						else System.out.println("Game over, player wins with: " + player.hand.cards); break; // player wins with blackjack
				case 3: break;
				case 4: if(player.hand.blackjack == 0) System.out.println("Game over, player and dealer tie with Blackjack. "); // player and dealer draw with blackjacks 
						else System.out.println("Game over, player and dealer tie. "); break;// player and dealer draw
				case 5: break;
				case 6: System.out.println("Game over, player surrendered hand. "); break;// player surrenders
				case 7: System.out.println("Game over, dealer loses with: " + dealer.hand.cards); break;// Dealer goes over 21
				case 8: if(dealer.hand.blackjack == 0) System.out.println("Game over, dealer wins with Blackjack: " + dealer.hand.cards); // dealer wins with blackjack
						else System.out.println("Game over, dealer wins with: " + dealer.hand.cards); break; // dealer wins without blackjack
				default: break;
			}
		}
		
		if(player.hand.split == 1){ //Results for split games
			System.out.println(player.getName());
			System.out.println("_____________________________________");
			switch(player.hand.gameResults){
				case 0: break;  // default setting
				case 1: System.out.println("Game over, player loses with: " + player.hand.cards); break;// player loses
				case 2: if(player.hand.blackjack == 0) System.out.println("Game over, player wins with Blackjack: " + player.hand.cards); // player wins without black jack 
						else System.out.println("Game over, player wins with: " + player.hand.cards); break; // player wins with blackjack
				case 3: break;
				case 4: if(player.hand.blackjack == 0) System.out.println("Game over, player and dealer tie with Blackjack. "); // player and dealer draw with blackjacks 
						else System.out.println("Game over, player and dealer tie. "); break;// player and dealer draw
				case 5: break;
				case 6: System.out.println("Game over, player surrendered hand. "); break;// player surrenders
				case 7: System.out.println("Game over, dealer loses with: " + dealer.hand.cards); break;// Dealer goes over 21
				case 8: if(dealer.hand.blackjack == 0) System.out.println("Game over, dealer wins with Blackjack: " + dealer.hand.cards); // dealer wins with blackjack
						else System.out.println("Game over, dealer wins with: " + dealer.hand.cards); break; // dealer wins without blackjack
				default: break;
			}
		}
	}
}
