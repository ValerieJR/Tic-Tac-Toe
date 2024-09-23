import java.util.Scanner;

public class TicTacToe {
    private LinkedList board;  // The board represented by a linked list
    private String currentPlayer;  // Keeps track of current player ('X' or 'O')

    // Constructor to initialize the game
    public TicTacToe() {
        this.board = new LinkedList();
        board.insertAtEnd("1");
        board.insertAtEnd("2");
        board.insertAtEnd("3");
        board.insertAtEnd("4");
        board.insertAtEnd("5");
        board.insertAtEnd("6");
        board.insertAtEnd("7");
        board.insertAtEnd("8");
        board.insertAtEnd("9");
        System.out.println();
        this.currentPlayer = "X";  // 'X' starts the game
    }

    // Method to switch players
    public void switchPlayer() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }

    // Method to play the game
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        while (!board.isBoardFull() && !gameWon) {
            board.displayBoard();
            System.out.println("Player " + this.currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();

            // Validate move and update board
            if (move >= 1 && move <= 9 && board.getPositionValue(move).equals("")) {
                board.updatePosition(move, this.currentPlayer);
                gameWon = board.checkWinCondition();

                if (!gameWon) {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        board.displayBoard();

        if (gameWon) {
            System.out.println("Player " + this.currentPlayer + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
        board.resetBoard();

    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner cont = new Scanner(System.in);
        System.out.println("Do you wish to play? Enter Y for yes or N for no");
        String response;
        response = cont.next();
        if(response.equals("Y")){
            game.playGame();
        }
        while(response.equals("Y")){
            System.out.println("Do you wish to play again? Enter Y for yes or N for no");
            response = cont.next();
            game.playGame();

        }



    }
}
