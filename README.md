# Implementation of BlackJack using State Pattern and Factory Pattern
This repository is a terminal application of the classic gambling game called **[BlackJack a.k.a Twenty-One.](https://en.wikipedia.org/wiki/Blackjack)** BlackJack is a comparing card game between usually several players and a dealer, 
where each player in turn competes against the dealer, but players do not play against each other. It is played with one or 
more decks of 52 cards, and is the most widely played casino banking game in the world. The objective of the game is to beat 
the dealer in one of the following ways:
  * Get 21 points on the player's first two cards (called a "blackjack" or "natural"), without a dealer blackjack;
  * Reach a final score higher than the dealer without exceeding 21; or
  * Let the dealer draw additional cards until their hand exceeds 21.
<br></br>
The Basic Strategy for a player to take decision based on the hand. For convenience Double is not implemented.
![BlackJack Basic Strategy](https://wizardofodds.com/blackjack/images/bj_2d_s17.gif)
  
The implementation does not have any user interface and the main objective is to accomplish the game of BlackJack to use **[State Design Pattern](https://en.wikipedia.org/wiki/State_pattern)** and **[Factory Design Pattern.](https://en.wikipedia.org/wiki/Factory_method_pattern)** The state design pattern is the best choice to implement BlackJack since the game has finite number of states. This game is played with a standard 6 decks of 52 cards each. Additionally, the game is implemented to accommodate any number of decks and any number of players. The major state changes occur in [GameClass.java](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/classes/GameClass.java) where the method [play()](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/classes/GameClass.java#L198) handles the state behaviour of the players and the dealer. The factory pattern is implemented in [GameFactory.java](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/classes/GameFactory.java). The factory pattern was used to create specialized versions of the game by creating subclasses of GameClass.
<br></br>

Various states employed to implement the game of BlackJack are : 
  * **[Start Game State](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/states/StartGameState.java)**  :  Sets the state of play to **Start State** for a specified player.
  
  * **[Player Turn State](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/states/PlayerTurnState.java)**  : Sets the state to **Player Turn State** for a specified player. Player can either hit or stand based on the combinations mentioned in the chart.
  
  * **[End Round State](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/states/EndRoundState.java)**  : Sets the state of the specified player to **End Round State**. The player can no longer hit the deck of cards after this state. The player may either be busted or in Stand state.
  
  * **[Dealer Turn State](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/states/DealerTurnState.java)**  : Sets the **Dealer Turn State** to all the players. After all the players have either decided to stand or if the players are busted, dealer now starts to play.
  
After all the states are completed, based on evaluating dealer's sum of cards, [winners](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/classes/GameClass.java#L620) are evaluated and the [winning amount](https://github.com/srijitravi94/BlackJack-State-Pattern/blob/master/src/main/java/edu/northeastern/ccs/cs5500/classes/GameClass.java#L650) is distributed to the players.
