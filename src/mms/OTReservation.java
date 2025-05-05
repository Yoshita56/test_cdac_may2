package mms;

import java.util.Scanner;

public class OTReservation {

    static int filled = 0;

    public static void main(String[] args) {
        // two- dimensional array with 7 rows and 4 columns
        char[][] seats = new char[7][4];
        for (int i = 0; i < 7; i++) {
            seats[i][0] = 'A';
            seats[i][1] = 'B';
            seats[i][2] = 'C';
            seats[i][3] = 'D';
        }

        String seatNumber = " ";
        String q = " ";
        System.out.println("Welcome to the Operation Theater Reservation System. Total 28 Tables Avaliable");
        System.out.println("Please enter the OT Table  (e.g.- 1A) you wish to reserve.");
        System.out.println("Enter q to exit.");
        Scanner keyboard = new Scanner(System.in);
        seatNumber = keyboard.nextLine();
        if (seatNumber.equals("q")) {
            System.out.println("Program ended.");
            System.exit(0);
        }
        // print seating pattern and put an X in the seatNumber location
        while (filled < 28 && seatNumber.length() > 0) 
        {
            int row = seatNumber.charAt(0) - '1';
            int col = seatNumber.charAt(1) - 'A';
            if (row < 0 || row > 7 || col < 0 || col > 4) 
            {
                System.out.println("Input error. Enter Table to assign (e.g., '1A')," + "or q to quit.");
                seatNumber = keyboard.nextLine();
                if (seatNumber.equals("q")) 
                {
                    System.out.println("Program ended.");
                    System.exit(0);
                }
            } 
            else 
            {
                if (seats[row][col] != 'X') 
                {
                    seats[row][col] = 'X';
                    filled++;
                    System.out.println(" ");
                    printSeats(seats);
                }
                if (filled < 28) {
                    System.out.println("Enter Table to assign (e.g., '1A')," + "or q to quit.");
                    seatNumber = keyboard.nextLine();
                    if (seatNumber.equals("q")) {
                        System.out.println("Program ended.");
                        System.exit(0);
                    }
                }
            }
        }
    }

    private static void printSeats(char[][] seats) {
        System.out.println("Row");
        for (int i = 0; i < seats.length; i++) {
            System.out
                    .println((i + 1) + "  " + seats[i][0] + " " + seats[i][1] + "  " + seats[i][2] + " " + seats[i][3]);

        }
        int numberOfSeatsAvailable = (28 - filled);
        System.out.println("There are " + numberOfSeatsAvailable + " Table available.");
    } // end main
} // end class