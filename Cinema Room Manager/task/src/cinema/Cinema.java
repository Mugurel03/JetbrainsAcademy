package cinema;

import java.util.Scanner;

public class Cinema {
    private static char[][] cinemaRoom;

    private static final int priceUnder60 = 10;
    private static final int frontHalfPrice = 10;
    private static final int backHalfPrice = 8;

    private static final char seat = 'S';
    private static final char busy = 'B';

    private static Scanner scanner = new Scanner(System.in);

    private static int frontHalfSeats = 10;
    private static int backHalfSeats = 8;

    private static int currentIncome;
    private static int numberOfTicketsBought;
    private static int totalIncome;


    public static void main(String[] args) {
        showMenu();
    }

    public static void cinemaInitialize() {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        cinemaRoom = new char[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinemaRoom[i][j] = seat;
            }
        }

        int totalNumOfSeats = cinemaRoom.length * cinemaRoom[0].length;

        if (totalNumOfSeats <= 60) {
            totalIncome = totalNumOfSeats * priceUnder60;
        } else {
            int frontHalfRows = cinemaRoom.length / 2;
            int totalFrontHalf = frontHalfRows * cinemaRoom[0].length * frontHalfPrice;
            int totalBackHalf = (cinemaRoom.length - frontHalfRows) * cinemaRoom[0].length * backHalfPrice;
            totalIncome = totalFrontHalf + totalBackHalf;
        }


    }

    public static void printCinemaRoom(char[][] cinemaRoom) {
        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 1; i <= cinemaRoom[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < cinemaRoom.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaRoom[0].length; j++) {
                System.out.print(" " + cinemaRoom[i][j]);
            }
            System.out.println();
        }
    }

    public static void takeTickets(char[][] cinemaRoom) {

        int totalNumberOfSeats = cinemaRoom.length * cinemaRoom[0].length;

        int rowNumber;
        int seatNumber;

        while (true) {
            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();

            if (rowNumber > cinemaRoom.length || seatNumber > cinemaRoom[0].length) {
                System.out.println("Wrong input!");
            } else {
                if (cinemaRoom[rowNumber - 1][seatNumber - 1] == busy) {
                    System.out.println("That ticket has already been purchased!");
                } else {
                    break;
                }
            }
        }

        int priceTicket;
        if (totalNumberOfSeats <= 60) {
            priceTicket = priceUnder60;
        } else {
            int frontHalfRows = cinemaRoom.length / 2;
            if (rowNumber <= frontHalfRows) {
                priceTicket = frontHalfPrice;
            } else {
                priceTicket = backHalfPrice;
            }

        }

        currentIncome += priceTicket;
        numberOfTicketsBought++;

        System.out.println("Ticket price: $" + priceTicket);
        cinemaRoom[rowNumber - 1][seatNumber - 1] = busy;

    }

    public static void showStatistics(char[][] cinemaRoom) {
        System.out.println("Number of purchased tickets: " + numberOfTicketsBought);

        float totalNumOfSeats = cinemaRoom.length * cinemaRoom[0].length;
        float percentageOfPurchased = 100 / totalNumOfSeats * numberOfTicketsBought;
        System.out.printf("Percentage: %.2f%s%n", percentageOfPurchased, "%");

        System.out.println("Current income: $" + currentIncome);

        System.out.println("Total income: $" + totalIncome);
    }

    public static void showMenu() {
        cinemaInitialize();

        int command;

        do {
            System.out.println("1 . Show the seats" +
                    "\n2. Buy a ticket" +
                    "\n3. Statistics" +
                    "\n0. Exit");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    printCinemaRoom(cinemaRoom);
                    break;
                case 2:
                    takeTickets(cinemaRoom);
                    break;
                case 3:
                    showStatistics(cinemaRoom);
                case 0:
                    break;
                default:
                    System.out.println("Error, command not found!");
            }

        } while (command != 0);
    }

}