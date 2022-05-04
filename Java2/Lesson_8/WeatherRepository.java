package Lesson8;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeatherRepository {

    private final String dbUrl;

    public WeatherRepository(String dbPath) {
        this.dbUrl = String.format("jdbc:sqlite:%s", dbPath);
        initDb();
    }

    private void initDb() {
        String sql = "CREATE TABLE IF NOT EXISTS weather (\n"
                + "city VARCHAR(100), \n"
                + "weather_date DATE, \n"
                + "min_temperature DOUBLE, \n"
                + "max_temperature DOUBLE \n"
                + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save(Weather weather) {
        deleteByDate(weather.getDate());

        String sql = "INSERT INTO weather(city, weather_date, min_temperature, max_temperature) VALUES(?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, weather.getCity());
            pstmt.setDate(2, convertToDate(weather.getDate()));
            pstmt.setDouble(3, weather.getMinTemperature());
            pstmt.setDouble(4, weather.getMaxTemperature());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save(List<Weather> weatherList) {
        for (Weather weather : weatherList) {
            save(weather);
        }
    }

    public List<Weather> getByDate(LocalDate fromDate, LocalDate toDate) {
        String sql = "SELECT * FROM weather where weather_date >= ? and weather_date <= ?";

        List<Weather> weatherList = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, convertToDate(fromDate));
            pstmt.setDate(2, convertToDate(toDate));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    weatherList.add(mapToEntity(rs));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return weatherList;

    }

    public void deleteByDate(LocalDate date) {
        String sql = "delete from weather where weather_date = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, convertToDate(date));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Weather> getAll() {
        String sql = "SELECT * FROM weather";

        List<Weather> weatherList = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                weatherList.add(mapToEntity(rs));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return weatherList;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private Weather mapToEntity(ResultSet rs) throws SQLException {
        return Weather.builder()
                .city(rs.getString("city"))
                .date(convertToLocalDate(rs.getDate("weather_date")))
                .minTemperature(rs.getDouble("min_temperature"))
                .maxTemperature(rs.getDouble("max_temperature"))
                .build();
    }

    public static Date convertToDate(LocalDate date) {
        return Date.valueOf(date);
    }

    public static LocalDate convertToLocalDate(Date date) {
        return date.toLocalDate();
    }

}

