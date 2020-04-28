# RockPaperScissor Game

This game is between a human player and a computer.
The Human player must type his input on command Line:
- The number of rounds he wants to play (an integer).

And at each round the human player must input his Move choice :
- 'R' : Rock
- 'S' : Scissors
- 'P' : Paper

The computer choices are random.

###Technical Choices :

Java 11
Maven
Junit Jupiter 5.6.2
Mockito-Jupiter 3.3.3
Hamcrest 2.2.2

###Design :
 I modeled Moves and Results as Enumerations.
 - Move contains (ROCK, PAPER, SCISSORS)
 - Result contains (TIE, SUCCESS, LOSS)