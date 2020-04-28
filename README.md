# RockPaperScissor Game

This game is between a human player and a computer.
The Human player must type his input on command Line:
- The number of rounds he wants to play (an integer).

And at each round the human player must input his Move choice :
- 'R' : Rock
- 'S' : Scissors
- 'P' : Paper

The computer choices are random.

To launch the game, you need to run the class Game that contains the main() method.
###Technical Choices :

Java 11
Maven
Junit Jupiter 5.6.2
Mockito-Jupiter 3.3.3
Hamcrest 2.2.2

###Design :
 I modeled Moves and Results as Enumerations.
 - Move contains (ROCK, PAPER, SCISSORS).
 
      I chose to create two static maps inside the Move enum. One map "strongerToWeakerMoveMap" that associates 
      each move to the move it beats. And another map "mnemonicToMoveMap" that associates each mnemonic character
      ('R', 'S', 'P') to its move (ROCK, PAPER, SCISSORS). I also added two methods that use these maps. "fromMnemonic()" 
      that gets a move using a character, and "beats()" that checks if a move beats a moved passed in the parameters.
 
 - Result contains (TIE, SUCCESS, LOSS), each RESULT has a special message that we use to report the result to the console.
 
 ConsoleReader class has two methods that get the input from the console. One gets a character used to get the Move, and the other 
 method is used to get the number of rounds a player wants to play.
 
 - I designed HumandPlayer and ComputerPlayer in different classes. They both extends an abstract class Player.
 ComputerPlayer uses the rest of the division of a randomly generated number by 3 to choose a move.
 HumanPlayer gets to choose using an input from the console.
 
 - Game class, is the main class that needs to be launched to play the game.
 It has a play method that loops n times calling the playRound method. (n being the numberOfRounds that a player wants to play).
 
 - For testing, I used Mockito to mock some objects. I made use of parameterized tests to avoid code duplication and
 to cover all scenarios.