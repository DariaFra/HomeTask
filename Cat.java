class Cat extends Animal {
    Cat(int maxRun) {
        super("Cat", maxRun, 0);
    }

    @Override
    public String maxSwim(int swimDistance) {
        return "cat can't swim";
    }
}

