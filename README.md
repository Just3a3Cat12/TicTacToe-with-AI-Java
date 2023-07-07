# Tic Tac Toe with AI

Welcome to Tic Tac Toe with AI! This project allows you to play the classic game of Tic Tac Toe against different AI opponents. The AI opponents are designed using the Minimax algorithm, providing varying levels of difficulty. You can also play against another human player.

## Game Modes

1. **User Mode**: Play against another human player. Take turns and compete to get three symbols in a row to win the game.

2. **Easy Mode**: Play against an AI opponent in easy mode. The AI opponent makes random moves, providing a more relaxed and beginner-friendly experience.

3. **Medium Mode**: Play against an AI opponent in medium mode. The AI opponent uses an improved strategy to make more intelligent moves, challenging you to step up your game.

4. **Hard Mode**: Play against an unbeatable AI opponent. The AI uses the Minimax algorithm to make optimal moves, making it extremely difficult to win against.

## Features

- Choose the game mode: user, easy, medium, or hard.
- Visual representation of the game board in the console.
- Intelligent AI opponents using the Minimax algorithm.
- Error handling for invalid moves or inputs.
- Display of game results (win, lose, or draw).
- Option to play again after the game ends.

## Requirements

- Java 17 or higher

## How to Run

1. Clone this repository to your local machine or download the source code as a ZIP file.
2. Open the project in your favorite Java IDE.
3. Build the project to compile the source code.
4. Run the main class (TicTacToe) to start the game.
5. Follow the on-screen instructions to select the game mode and make your moves.

## Game Rules

- The game is played on a 3x3 grid.
- The first player is 'X', and the second player is 'O'.
- Players take turns marking a free cell with their respective symbol ('X' or 'O').
- The objective is to get three of your symbols in a row, either horizontally, vertically, or diagonally.
- If all cells are filled and no player has three in a row, the game ends in a draw.

## How the Minimax Algorithm Works

The Minimax algorithm is a decision-making algorithm commonly used in games with perfect information. In this game, it allows the AI opponents to make optimal moves.

1. The AI player (Maximizer) assigns a score to each possible move.
2. The AI explores all possible moves and their resulting game states.
3. If a move results in a win, the AI assigns a score of +1.
4. If a move results in a loss, the AI assigns a score of -1.
5. If a move results in a draw, the AI assigns a score of 0.
6. The AI assumes the opponent (Minimizer) will also make optimal moves.
7. The AI selects the move with the maximum score (for the Maximizer) or minimum score (for the Minimizer).
8. The AI continues exploring and evaluating moves until it reaches a terminal game state.

## Credits

This project is inspired by the game of Tic Tac Toe and the Minimax algorithm. It was developed by PANKAJ AMBEKAR as a demonstration of the Minimax algorithm and its application in game development.

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to contribute to the project by submitting bug reports, feature requests, or pull requests. Enjoy playing Tic Tac Toe with AI!
