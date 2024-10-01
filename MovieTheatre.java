// Author: Steve Sharpe

import java.util.Scanner;

public class MovieTheatre {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final char EMPTY = 'O';
    private static final char TAKEN = 'X';
    private static char[][] seatingChart = new char[ROWS][COLS];

    public static void main(String[] args) {
        initializeSeatingChart(); // Initialize the seating chart with empty seats
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display menu options
            System.out.println("1. Reserve seats");
            System.out.println("2. Cancel seats");
            System.out.println("3. Retrieve initial seating chart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reserveSeats(scanner); // Reserve seats
                    break;
                case 2:
                    cancelSeats(scanner); // Cancel reserved seats
                    break;
                case 3:
                    retrieveSeatingChart(); // Display the seating chart
                    break;
                case 4:
                    scanner.close(); // Close the scanner before exiting
                    System.exit(0); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Initialize the seating chart with empty seats
    private static void initializeSeatingChart() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seatingChart[i][j] = EMPTY;
            }
        }
    }

    // Display the seating chart
    private static void retrieveSeatingChart() {
        System.out.println("Seating Chart:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Reserve a seat by specifying row and column
    private static void reserveSeats(Scanner scanner) {
        System.out.print("Enter the row number (0-9): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column number (0-9): ");
        int col = scanner.nextInt();
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat position. Please try again.");
            return;
        }
        if (seatingChart[row][col] == TAKEN) {
            System.out.println("Seat already taken. Please choose another seat.");
        } else {
            seatingChart[row][col] = TAKEN;
            System.out.println("Seat reserved successfully.");
        }
    }

    // Cancel a reserved seat by specifying row and column
    private static void cancelSeats(Scanner scanner) {
        System.out.print("Enter the row number (0-9): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column number (0-9): ");
        int col = scanner.nextInt();
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat position. Please try again.");
            return;
        }
        if (seatingChart[row][col] == EMPTY) {
            System.out.println("Seat is already empty.");
        } else {
            seatingChart[row][col] = EMPTY;
            System.out.println("Seat cancelled successfully.");
        }
    }
}