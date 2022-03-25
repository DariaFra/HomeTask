package Lesson1;

public class Main {

    public static void main(String[] args) {
        Team[] team = {
                new Team("stars 1", 50, 50, 10),
                new Team("stars 2", 70, 70, 5),
                new Team("stars 3", 80, 50, 20),
                new Team("stars 4", 60, 80, 10)
        };

        for (int i = 0; i < team.length; i++) {
            System.out.println(team[i]);
        }

        Course course = new Course(60, 50, 10);
        System.out.println(course);

        for (int i = 0; i < team.length; i++) {
            if (team[i].getRunDistance() >= course.getTrack() && team[i].getSwimDistance()
                    >= course.getPool() && team[i].getJumpHeight() >= course.getWall()) {
                System.out.println("Team " + team[i].getName() + " finish distance");
            } else {
                System.out.println("Team " + team[i].getName() + " didn't finish distance");
            }
        }
    }
}
