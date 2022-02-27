/**
 * Java 1. Homework 6.
 *
 * @author Daria
 * @version 27.02.2022
 */
class HomeWork6 {
    public static void main(String[] args) {
        IAnimal[] animals = {
                new Cat(200),
                new Cat(200),
                new Dog(500, 10)
        };
        for (IAnimal animal : animals) {
            System.out.println(animal.maxRun(150));
            System.out.println(animal.maxRun(250));
            System.out.println(animal.maxSwim(5));
            System.out.println(animal.maxSwim(15));
        }
        int countCat = 0;
        int countDog = 0;
        for (IAnimal animal : animals) {
            if (animal instanceof Cat) countCat++;
            if (animal instanceof Dog) countDog++;
        }
        System.out.println("All cats " + countCat);
        System.out.println("All dogs " + countDog);
    }
}

interface IAnimal {
    String maxRun(int runDistance);

    String maxSwim(int swimDistance);
}
