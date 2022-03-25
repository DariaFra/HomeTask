/**
 * Java 1. Homework 7.
 *
 * @author Daria
 * @version 02.03.2022
 */
class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = fullness;
    }

    public String getName() {

        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    void eat(Plate plate) {

        plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {

        return "Cat: " + name + ", appetite " + appetite;
    }
}
