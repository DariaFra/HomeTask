package Lesson5;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{100, 200, 123}, {300, 400, 500}};
        File file = new File("Value.csv");
        AppData appData = new AppData(header, data);
        appData.record("Value.csv");

        appData.load("Value.csv");
        System.out.println(Arrays.toString(appData.getHeader()));
        for (int i = 0; i < data.length; i++) {
            System.out.println(Arrays.toString(appData.getData()[i]));
        }
    }
}
