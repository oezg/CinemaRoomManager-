package cinema;
import java.util.Scanner;
public class Cinema {
    static int tickets = 0;
    static int sold = 0;
    static int r = 0;
    static int c = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] cinema;
        int choice;
        boolean flag = true;
        cinema = initialize();
        while (flag) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    print(cinema);
                    break;
                case 2:
                    choose(cinema);
                    break;
                case 3:
                    stats(cinema);
                    break;nbvcxykj
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
    static void stats(char[][] cinema) {
        System.out.printf("Number of purchased tickets: %d%n", tickets);
        double perc = 100.0 * tickets / (r*c);
        System.out.printf("Percentage: %.2f%%%n", perc);
        System.out.printf("Current income: $%d%n", sold);
        System.out.printf("Total income: $%d%n", income());
    }
    static void choose(char[][] cinema) {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        boolean nok = false;
        do {
            System.out.println("Enter a row number:");
            x = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            y = scanner.nextInt();
            if (x > r || y > c) {
                System.out.println("\nWrong input!");
                nok = true;
            } else if (cinema[x][y] == 'B') {
                nok = true;
                System.out.println("\nThat ticket has already been purchased");
            } else {
                nok = false;
            }
        } while (nok);
        cinema[x][y] = 'B';
        tickets++;
        int price = r * c > 60 ? x > r / 2 ? 8 : 10 : 10;
        sold += price;
        System.out.printf("Ticket price: $%d%n%n", price);
    }
    static int income() {
        return r * c > 60 ? 8 * r * c + 2 * c * (r / 2) : r * c * 10;
    }
    static char[][] initialize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        r = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        c = scanner.nextInt();
        char[][] cinema = new char[r + 1][c + 1];
        cinema[0][0] = ' ';
        for (int i = 1; i < cinema[0].length; i++) {
            cinema[0][i] = Character.forDigit(i,10);
        }
        for (int i = 1; i < cinema.length; i++) {
            cinema[i][0] = Character.forDigit(i,10);
        }
        for (int i = 1; i < cinema.length; i++) {
            for (int j = 1; j < cinema[i].length; j++) {
                cinema[i][j] = 'S';
            }
        }
        return cinema;
    }
    static void print(char[][] cinema) {
        System.out.println("Cinema:");
        for (int i = 0; i < cinema.length; i++) {
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.printf("%c ", cinema[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }
}