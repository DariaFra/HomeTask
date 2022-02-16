/**
 * Java 1. Homework 2.
 *
 * @author Daria
 * @version 16.02.2022
 */

import java.util.Arrays;

class HomeWork3 {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        cheangingElements();
        System.out.println("\nЗадание 2");
        fillingNumbers();
        System.out.println("\nЗадание 3");
        multipliedBy();
        System.out.println("\nЗадание 4");
        twoDimArray();
        System.out.println("\nЗадание 5");
        System.out.println(Arrays.toString(creatMasive(7, 4)));
    }

    static void cheangingElements() {
        int[] elements = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print(Arrays.toString(elements) + " \n");
        for (int i = 0; i < elements.length; i++) {
            elements[i] = (elements[i] + 1) % 2;
        }
        System.out.print(Arrays.toString(elements));
    }

    static void fillingNumbers() {
        int[] num = new int[100];
        System.out.print(Arrays.toString(num) + "\n");
        for (int i = 0; i < num.length; i++) {
            num[i] = i + 1;
        }
        System.out.print(Arrays.toString(num));
    }

    static void multipliedBy() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print(Arrays.toString(arr) + "\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] = arr[i] * 2;
        }
        System.out.print(Arrays.toString(arr));
    }

    static void twoDimArray() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i][i] = 1;
        }
        for (int i = 4, j = 0; i >= 0; i--, j++) {
            arr[i][j] = 1;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[] creatMasive(int len, int initialValue) {
        int[] num = new int[len];
        Arrays.fill(num, initialValue);
        return num;
    }
}
