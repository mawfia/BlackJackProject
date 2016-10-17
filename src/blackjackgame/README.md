##Blackjack Card Game Project
------------------------------------------------------------

This program was created on 14 October 2016 by Michael Andrew Williams

This program simulates a Blackjack game with the basic functionality of being dealt two cards at which point the player may choose to draw another card, hold, or surrender.  Blackjakcs are recognized as only face cards and aces.  Aces have both a value of 1 and 11 depending on the total value of cards in the player's hand.  The value of aces changes automatically as the player and dealer draw cards.  Splits are also supported and simulate casino play where same value cards initiate splits and player blackjacks after a split are treated as non-blackjack 21 when comparing against the dealers hand.  If time allows I will add the ability for the player to place bets as well as ASCII art for each card that would be displayed instead of text.

This program is comprised of eight classes two of which are for enums: BJTable.java, Deck.java, Card.java, Player.java, Hand.java, Dealer.java, Suit.java, and Rank.java.


BJTable Class:
------------------------------------------------------------
This class is the basic game engine and is where the card deck, dealer, player, and their respective playing hads are instantiated.  All methods handling dealing of cards and evaluating score are declared in this class.
	
	
Deck Class:
------------------------------------------------------------
This class instantiates the card class and generates a 52-card deck of unique card objects.  This class is also comprised of methods for displaying and shuffling the cards.

	
Player Class:
------------------------------------------------------------
This class instantiates a hand object to be used by the user during game play. This class also allows for storing the users name, currency, and displaying the cards stored in the hand or arraylist collection.

	
Hand class:
------------------------------------------------------------
This class is used for storing cards for multiple users and the dealer during game play.  This class maintains count of cards, changes the value of aces depending on the total value of cards stored, and indicates when there is a blackjack or split. 


Dealer class:
------------------------------------------------------------
This class has the same structure and organization as the Player.java class, minus a wallet or account for placing bets.  This class controls the way in which the dealer displays cards and determines when then Dealer will draw, or hold duirng game play.

Suit and Rank Enum Classes
------------------------------------------------------------
Serve as labels for the 52-card deck generated in the card class.