
public class HomeWork1 {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 1;
        int b = -2;
        if (a + b > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    static void printColor() {
        int value = 108;
        if (value <= 0) {
            System.out.println("Red");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Yellow");
        }
        if (value > 100) {
            System.out.println("Green");
        }

    }

    static void compareNumbers() {
        int a = 9;
        int b = 6;
        System.out.println(a >= b ? "a>=b" : "a<b");
    }

}
