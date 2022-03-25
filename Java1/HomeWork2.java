/**
 * Java 1. Homework 2.
 *
 * @author Daria
 * @version 11.02.2022
 */
public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println(sumAmountIsWithin(9, 7));
        boolean result = isNumberPositive(5);
        System.out.println(result ? "Positive" : "negative");
        System.out.println(isNumberNegative(5));
        numberOfRows(("Hello everyone!"), 5);
        boolean result1 = yearLeap(2008);
        System.out.println(result1 ? "Год високосный, а это значит в нем 366 дней!" : "Год не високосный");

    }

    static boolean sumAmountIsWithin(int a, int b) {

        return a + b >= 10 && a + b <= 20;
    }

    static boolean isNumberPositive(int a) {

        return a >= 0;
    }

    static boolean isNumberNegative(int s) {

        return s < 0;
    }

    static void numberOfRows(String word, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(word);
        }
    }

    static boolean yearLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
   