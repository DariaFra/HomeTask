/**
 * Java 1. Homework 7.
 *
 * @author Daria
 * @version 02.03.2022
 */
class Plate {
    private int food;

    Plate(int food) {

        this.food = food;
    }

    void decreaseFood(int food) {

        this.food -= food;
    }

    void increaseFood(int food) {

        this.food += food;
    }

    public int getFood() {

        return food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}

