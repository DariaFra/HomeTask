package Lesson5;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AppData {
    private String[] header;
    private int[][] data;

    AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void record(String file) {
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("Value.csv"))) {
            String headerStr = String.join(",", header);
            writer.write(headerStr);
            writer.newLine();
            for (int[] row : data) {
                String rowStr = Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(";"));
                writer.write(rowStr);
                writer.newLine();
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String file) {

        StringBuilder content = new StringBuilder();
        try (
                BufferedReader reader = new BufferedReader(new FileReader("Value.csv"));) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
