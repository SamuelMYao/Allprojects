import java.util.Scanner;

public class Maze {
    static Scanner sc = new Scanner(System.in);
    static char myMove = '\0';
    static int currentCell = 0;
    static int score = 0;
    static boolean advance = true;
    static boolean checkThis = false;
    static int moves = 0;

    public static void main(String args[]) {
        char answer = 'Y';
        displayMenu();
        
        while (answer == 'Y' || answer == 'y') {
            displayMovement();
            makeYourMove();
            checkThis = checkYourMove();
            mazeStatus();
            moves++; // Increment move counter
            System.out.println("Current score: " + score);
            System.out.println("Move again (Y or N)?");
            answer = sc.next().charAt(0);
        }
        
        System.out.println("***************************");
        System.out.println("Total moves: " + moves);
        System.out.println("Final score: " + score);
        sc.close();
    }

    static void displayMenu() {
        System.out.println("");
        System.out.println("***************************");
        System.out.println("---- The Maze Strategy ----");
        System.out.println("");
    }

    static void displayMovement() {
        if (currentCell == 0) {
            System.out.println("You have entered the maze!!");
            System.out.println("There is no turning back!!");
            currentCell = 1;
            mazeStatus();
            advance = true;
        }
        System.out.println("Make your move (W, A, S, D)");
        System.out.println("W = up, A = left, S = down, D = right");
    }

    static void makeYourMove() {
        myMove = sc.next().charAt(0);
        switch (myMove) {
            case 'W': {
                MoveUp();
                score += 10; // Adjust score based on move
                break;
            }
            case 'A': {
                MoveLeft();
                score += 5; // Adjust score based on move
                break;
            }
            case 'S': {
                MoveDown();
                score += 8; // Adjust score based on move
                break;
            }
            case 'D': {
                MoveRight();
                score += 12; // Adjust score based on move
                break;
            }
        }
    }

    static boolean checkYourMove() {
        if (currentCell == 1 && advance == true) {
            if (myMove == 'W') {
                advance = false;
                System.out.println("Try again");
                return advance;
            }
            if (myMove == 'A') {
                advance = false;
                System.out.println("SORRY, there is no return");
                return advance;
            }
            if (myMove == 'D') {
                currentCell = 2;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'S') {
                advance = false;
                System.out.println("Continue through the maze");
                return advance;
            }
        } else if (currentCell == 2 && advance == true) {
            if (myMove == 'W') {
                advance = false;
                System.out.println("Try again");
                return advance;
            }
            if (myMove == 'A') {
                advance = false;
                System.out.println("SORRY, there is no return");
                return advance;
            }
            if (myMove == 'D') {
                advance = false;
                System.out.println("Continue through the maze");
                return advance;
            }
            if (myMove == 'S') {
                currentCell = 5;
                advance = true;
                System.out.println("Continue through the maze");
                return advance;
            }
        }
        // Add similar conditions for other cells as needed
        return advance;
    }

    static void MoveLeft() {
        System.out.println("You moved to the left");
    }

    static void MoveRight() {
        System.out.println("You moved to the right");
    }

    static void MoveUp() {
        System.out.println("You moved up (forward)");
    }

    static void MoveDown() {
        System.out.println("You moved down (downward)");
    }

    static void mazeStatus() {
        System.out.println("Current position: cell " + currentCell);
    }
}
