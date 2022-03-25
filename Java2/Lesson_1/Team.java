package Lesson1;

public class Team {
    private String name;
    private int runDistance;
    private int swimDistance;
    private int jumpHeight;

    public Team(String name, int runDistance, int swimDistance, int jumpHeight) {
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public String toString() {
        return "Team " + "name " + name + " run distance " + runDistance + " swim distance "
                + swimDistance + " jump height " + jumpHeight;
    }

    public void run(Course course) {
        course.runTrack(runDistance);
    }

    public void swim(Course course) {
        course.swimPool(swimDistance);
    }

    public void jump(Course course) {
        course.jumpWall(jumpHeight);
    }

    public String getName() {
        return name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

}
