
/**
 * Java 1. Homework 7.
 *
 * @author Daria
 * @version 02.03.2022
 */
class HomeWork7 {
    public static void main(String[] args) {
        Cat[] cat = {
                new Cat("Barsik", 5, false),
                new Cat("Murzik", 15, false),
                new Cat("Boris", 10, false),
                new Cat("Marsik", 20, false)
        };

        for (int i = 0; i < cat.length; i++) {
            System.out.println(cat[i]);
        }

        Plate plate = new Plate(45);
        System.out.println(plate);
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].isFullness() == false && cat[i].getAppetite() < plate.getFood()) {
                cat[i].eat(plate);
                cat[i].setFullness(true);
                System.out.println("Cat " + cat[i].getName() + " fullness!");
            } else {
                System.out.println("Cat " + cat[i].getName() + " didn't eat");
            }
            System.out.println(plate);
        }
        System.out.println("We add to plate 10");
        plate.increaseFood(10);
        System.out.println(plate);
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].isFullness() == false && cat[i].getAppetite() < plate.getFood()) {
                cat[i].eat(plate);
                cat[i].setFullness(true);
                System.out.println("Cat " + cat[i].getName() + " fullness!");
            } else {
                System.out.println("Cat " + cat[i].getName() + " didn't eat");
            }
            System.out.println(plate);

        }
    }
}
