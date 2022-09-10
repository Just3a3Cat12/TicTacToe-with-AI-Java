import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static char[][] table = new char[3][3];
    static Scanner scanner = new Scanner(System.in);
    static int row;
    static int column;
    static int countX = 0;
    static int countO = 0;
    static boolean shutdown = true;
    static boolean aiV1chk = true;
    static int easyMedium = 0;
    static char selfPlayer;
    static char opponentPlayer;

    public static void printTable(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static void takingInput(char xo) {
        boolean chk = true;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt() - 1;
                if (scanner.hasNextInt()) {
                    column = scanner.nextInt() - 1;
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.next();
                    continue;
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.next();
                continue;
            }
            if (row < 0 || row > 2 || column < 0 || column > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (table[row][column] == 'X' || table[row][column] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                countXO(xo);
                printTable(table);
                break;
            }
        } while (chk);
    }

    public static void countXO(char xo) {
        if (xo == 'X') {
            countX++;
            table[row][column] = 'X';
        } else {
            countO++;
            table[row][column] = 'O';
        }
    }

    public static void countXOai(char xo) {
        if (xo == 'X') {
            countX++;
        } else {
            countO++;
        }
    }

    public static int sumHorizontal(int h1) {
        int sumH = 0;
        for (int i = 0; i < 3; i++) {
            sumH += table[h1][i];
        }
        return sumH;
    }

    public static int sumVertical(int v1) {
        int sumV = 0;
        for (int i = 0; i < 3; i++) {
            sumV += table[i][v1];
        }
        return sumV;
    }
    public static void computerMove(char xo) {
        if (aiV1chk) {
            Random random = new Random();
            boolean chk = true;
            if (easyMedium == 0) {
                System.out.println("Making move level \"easy\"");
            }
            while (chk) {
                row = random.nextInt(3);
                column = random.nextInt(3);
                if (table[row][column] == 'X' || table[row][column] == 'O') {
                    chk = true;
                } else {
                    countXO(xo);
                    chk = false;
                }
            }
        }
        printTable(table);
    }
    public static void winner(int moves) {
        if (moves > 4) {
            if (sumHorizontal(0) == 264 ||
                    sumHorizontal(1) == 264 ||
                    sumHorizontal(2) == 264 ||
                    sumVertical(0) == 264 ||
                    sumVertical(1) == 264 ||
                    sumVertical(2) == 264 ||
                    table[0][0] + table[1][1] + table[2][2] == 264 ||
                    table[2][0] + table[1][1] + table[0][2] == 264) {
                System.out.println("X wins");
                shutdown = false;
            } else if (sumHorizontal(0) == 237 ||
                    sumHorizontal(1) == 237 ||
                    sumHorizontal(2) == 237 ||
                    sumVertical(0) == 237 ||
                    sumVertical(1) == 237 ||
                    sumVertical(2) == 237 ||
                    table[0][0] + table[1][1] + table[2][2] == 237 ||
                    table[2][0] + table[1][1] + table[0][2] == 237) {
                System.out.println("O wins");
                shutdown = false;
            } else if (moves == 9) {
                System.out.println("Draw");
                shutdown = false;
            }
        }
    }

    public static int winner2() {
        if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == selfPlayer ||
                table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == selfPlayer ||
                table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][0] == selfPlayer ||
                table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == selfPlayer ||
                table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == selfPlayer ||
                table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == selfPlayer ||
                table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == selfPlayer ||
                table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == selfPlayer) {
            return 1;
        } else if (table[0][0] == table[0][1] && table[0][1] == table[0][2] && table[0][0] == opponentPlayer ||
                table[1][0] == table[1][1] && table[1][1] == table[1][2] && table[1][0] == opponentPlayer ||
                table[2][0] == table[2][1] && table[2][1] == table[2][2] && table[2][0] == opponentPlayer ||
                table[0][0] == table[1][0] && table[1][0] == table[2][0] && table[0][0] == opponentPlayer ||
                table[0][1] == table[1][1] && table[1][1] == table[2][1] && table[0][1] == opponentPlayer ||
                table[0][2] == table[1][2] && table[1][2] == table[2][2] && table[0][2] == opponentPlayer ||
                table[0][0] == table[1][1] && table[1][1] == table[2][2] && table[0][0] == opponentPlayer ||
                table[0][2] == table[1][1] && table[1][1] == table[2][0] && table[0][2] == opponentPlayer) {
            return -1;
        } else {
            return 0;
        }
    }
    public static void aiV1(int moves, char xo) {  //val = 208 or 190
        System.out.println("Making move level \"medium\"");
        aiV1chk = true;
        easyMedium = 1;
        int val;
        if (xo == 'X') {
            val = 190;
        } else {
            val = 208;
        }
        if (moves > 2) {
            for (int i = 0; i < 3 && aiV1chk; i++) {
                if (sumHorizontal(i) == val) {
                    if (table[i][0] == ' ') {
                        table[i][0] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[i][2] == ' ') {
                        table[i][2] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[i][1] == ' ') {
                        table[i][1] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    }
                }
                if (sumVertical(i) == val) {
                    if (table[0][i] == ' ') {
                        table[0][i] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[2][i] == ' ') {
                        table[2][i] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[1][i] == ' ') {
                        table[1][i] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    }
                }
                if (i == 0 && table[0][0] + table[1][1] + table[2][2] == val) {
                    if (table[0][0] == ' ') {
                        table[0][0] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[2][2] == ' ') {
                        table[2][2] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[1][1] == ' ') {
                        table[1][1] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    }
                } else if (i == 0 && table[2][0] + table[1][1] + table[0][2] == val) {
                    if (table[2][0] == ' ') {
                        table[2][0] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[0][2] == ' ') {
                        table[0][2] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    } else if (table[1][1] == ' ') {
                        table[1][1] = xo;
                        countXOai(xo);
                        aiV1chk = false;
                        break;
                    }
                }
            }
        }
    }

    public static void assignPlayer(char player) {
        if (player == 'X') {
            selfPlayer = player;
            opponentPlayer = 'O';
        } else {
            selfPlayer = player;
            opponentPlayer = 'X';
        }
    }

    public static void aiV3(char player) {
        System.out.println("Making computer move \"hard\"");
        int bestScore = Integer.MIN_VALUE;
        assignPlayer(player);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    table[i][j] = player;
                    int score = miniMax(0, false);
                    table[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        row = i;
                        column = j;
                    }
                }
            }
        }
        countXO(selfPlayer);
        printTable(table);
    }
    public static int availableMoves() {
        int c1 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == ' ') {
                    c1++;
                }
            }
        }
        return c1;
    }

    public static int miniMax(int depth, boolean isMaximizer) {
        if (availableMoves() == 0) {
            return 0;
        }
        if (winner2() != 0) {
            return winner2(); //- depth;
        }
        if (isMaximizer) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i][j] == ' ') {
                        table[i][j] = selfPlayer;
                        int score = miniMax(depth + 1, false);
                        table[i][j] = ' ';
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (table[i][j] == ' ') {
                        table[i][j] = opponentPlayer;
                        int score = miniMax(depth + 1, true);
                        table[i][j] = ' ';
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }
    public static void main(String[] args) {
        boolean terminate = true;
        System.out.println("""
                To start the game enter: start <command> <command>
                commands:
                    user    - To play as human
                    easy    - To play as an AI
                    medium  - To play as AIv2
                    hard    - To play as Unbeatable AI
                To exit the game enter: exit
                    ex. 1. start easy user
                        2. start user user
                        3. start easy hard
                        4. start hard user
                        5. start medium easy""");
        do {
            table = new char[][]{{' ', ' ', ' '} , { ' ', ' ', ' '} , { ' ', ' ', ' '}};
            shutdown = true;
            countO = 0;
            countX = 0;
            easyMedium = 0;
            System.out.print("Input command: ");
            String inputCommand = scanner.nextLine();
            String[] commands;
            commands = inputCommand.split(" ");
            try {
                if (Objects.equals(commands[0], "exit")) {
                    break;
                } else if (Objects.equals(commands[0], "start")) {
                    printTable(table);
                    do {
                        if (Objects.equals(commands[1], "user")) {
                            takingInput('X');
                        } else if (Objects.equals(commands[1], "easy")) {
                            computerMove('X');
                        } else if (Objects.equals(commands[1], "medium")) {
                            aiV1(countO + countX, 'X');
                            computerMove('X');
                        } else if (Objects.equals(commands[1], "hard")) {
                            aiV3('X');
                        } else {
                            System.out.println("Wrong command 1");
                            break;
                        }
                        winner(countO + countX);
                        if (shutdown) {
                            if (Objects.equals(commands[2], "user")) {
                                takingInput('O');
                            } else if (Objects.equals(commands[2], "easy")) {
                                computerMove('O');
                            } else if (Objects.equals(commands[2], "medium")) {
                                aiV1(countO + countX, 'O');
                                computerMove('O');
                            } else if (Objects.equals(commands[2], "hard")) {
                                aiV3('O');
                            } else {
                                System.out.println("Wrong command 2");
                                break;
                            }
                            winner(countO + countX);
                        }
                    } while (shutdown);
                } else {
                    System.out.println("Bad parameters!");
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.out.println("Bad parameters!");
            }
        } while (terminate);
    }
}
