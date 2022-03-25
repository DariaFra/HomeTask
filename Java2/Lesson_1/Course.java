package Lesson1;

public class Course {
    private int track;
    private int pool;
    private int wall;

    public Course(int track, int pool, int wall) {
        this.pool = pool;
        this.track = track;
        this.wall = wall;
    }

    public void runTrack(int track) {
        this.track = track;
    }

    public void swimPool(int pool) {
        this.pool = pool;
    }

    public void jumpWall(int wall) {
        this.wall = wall;
    }

    @Override
    public String toString() {
        return "Track: " + track + ", pool: " + pool + ", wall: " + wall;
    }

    public int getTrack() {
        return track;
    }

    public int getPool() {
        return pool;
    }

    public int getWall() {
        return wall;
    }
}
