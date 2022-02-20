/**
 * Java 1. Homework 2.
 *
 * @author Daria
 * @version 20.02.2022
 */

import java.util.Random;
import java.util.Scanner;

public class HomeWorkGame {
    Random random;
    Scanner scanner;
    char[][] table;

    public static void main(String[] args) {
        new HomeWorkGame().game();
    }

    HomeWorkGame() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    void game() {
        initTable();
        printTable();
        while (true) {
            turnHuman();
            if (checkWin('x')) {
                System.out.println("You won!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW...");
                break;
            }
            turnAI();
            printTable();
            if (checkWin('o')) {
                System.out.println("I won!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Sorry, DRAW...");
                break;
            }
        }
        System.out.print("Game over! \n");
        printTable();
    }

    void initTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                table[x][y] = '*';
            }
        }

    }

    void printTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(table[x][y] + " ");
            }
            System.out.println();
        }
    }

    void turnHuman() {
        int x, y;
        do {
            System.out.println("enter x y [1..3]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[x][y] = 'x';
    }


    void turnAI() {
        int x, y;
        for (int i = 0; i < 3; i++) {
            int xRowCount = 0;
            int xColCount = 0;
            int oRowCount = 0;
            int oColCount = 0;
            for (int j = 0; j < 3; j++) {
                xRowCount = table[i][j] == 'x' ? xRowCount + 1 : xRowCount;
                xColCount = table[j][i] == 'x' ? xColCount + 1 : xColCount;
                oRowCount = table[i][j] == 'o' ? oRowCount + 1 : oRowCount;
                oColCount = table[j][i] == 'o' ? oColCount + 1 : oColCount;
            }
            if (xRowCount == 2 || oRowCount == 2) {
                for (int j = 0; j < 3; j++) {
                    if (isCellValid(i, j)) {
                        table[i][j] = 'o';
                        return;
                    }
                }
            }
            if (xColCount == 2 || oColCount == 2) {
                for (int j = 0; j < 3; j++) {
                    if (isCellValid(j, i)) {
                        table[j][i] = 'o';
                        return;
                    }
                }
            }
        }


        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[x][y] = 'o';
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return false;
        }
        return table[x][y] == '*';
    }

    boolean checkWin(char ch) {

        for (int i = 0; i < 3; i++) {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < 3; j++) {
                rowCount = table[i][j] == ch ? rowCount + 1 : rowCount;
                colCount = table[j][i] == ch ? colCount + 1 : colCount;
            }
            if (rowCount == 3 || colCount == 3) return true;
        }

        if (table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) return true;
        if (table[2][0] == ch && table[1][1] == ch && table[0][2] == ch) return true;
        return false;
    }

    boolean isTableFull() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (table[x][y] == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
