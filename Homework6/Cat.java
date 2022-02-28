/**
 * Java 1. Homework 6.
 *
 * @author Daria
 * @version 27.02.2022
 */
class Cat extends Animal {
    Cat(int maxRun) {
        super("Cat", maxRun, 0);
    }

    @Override
    public String maxSwim(int swimDistance) {
        return "cat can't swim";
    }
}

