/**
 * Java 1. Homework 6.
 *
 * @author Daria
 * @version 27.02.2022
 */
abstract class Animal implements IAnimal {
    protected String animalType;
    protected int maxRun;
    protected int maxSwim;

    Animal(String animalType, int maxRun, int maxSwim) {
        this.animalType = animalType;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }

    @Override
    public String maxRun(int runDistance) {
        if (runDistance <= maxRun) {
            return animalType + " run " + runDistance + "m";
        } else {
            return animalType + " can't run so far";
        }
    }

    @Override
    public String maxSwim(int swimDistance) {
        if (swimDistance <= maxSwim) {
            return animalType + " swim " + swimDistance + "m";
        } else {
            return animalType + " can't swim so far";
        }
    }
}
