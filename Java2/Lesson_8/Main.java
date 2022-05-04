package Lesson8;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class Main {

    private static final String API_KEY = "D7772AuNIlTp9WV0o3l2M8reiswsu4BY";
    private static final String DB_PATH = "./test.db";

    public static void main(String... args) throws IOException, URISyntaxException {
        WeatherRepository weatherRepository = new WeatherRepository(DB_PATH);

        int numDays;
        String questionMessage = "Please enter number of day from 1 to 5 or 0 for exit: ";
        System.out.print(questionMessage);
        Scanner sc = new Scanner(System.in);
        while (true) {
            numDays = -1;
            try {
                numDays = Integer.parseInt(sc.nextLine());
                if (numDays == 0) {
                    return;
                } else if (numDays > 0 && numDays <= 5) {
                    System.out.println();

                    LocalDate currentDate = LocalDate.now();
                    LocalDate requestedDate = currentDate.plusDays(numDays);
                    List<Weather> weatherList = weatherRepository.getByDate(currentDate, requestedDate);
                    if (weatherList.size() < numDays) {
                        String json = get5dayWeather(API_KEY);
                        WeatherDto weatherDto = parsJsonToDto(json);
                        weatherList = convertToEntity(weatherDto);
                        weatherRepository.save(weatherList);
                    }
                    printWeatherForNDays(weatherList, numDays);



                } else {
                    System.out.println(String.format("Unsupported value '%s'", numDays));
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number");
            }
            System.out.print(questionMessage);
        }

    }

    private static void printWeatherForNDays(List<Weather> weatherList, int numDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String linePattern = "City: %s Day: %-10s Date: %s Min: %-5s Max: %-5s";
        for (int i = 0; i < numDays; i++) {
            Weather weather = weatherList.get(i);
            LocalDate date = weather.getDate();
            double minTemp = weather.getMinTemperature();
            double maxTemp = weather.getMaxTemperature();
            String city = weather.getCity();
            System.out.println(String.format(linePattern, city, date.getDayOfWeek(), date.format(formatter), minTemp, maxTemp));
        }
    }

    private static String get5dayWeather(String apikey) throws IOException, URISyntaxException {
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212";
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);
            URI uri = new URIBuilder(httpGet.getURI())
                    .addParameter("apikey", apikey)
                    .addParameter("details", "false")
                    .addParameter("metric", "true")
                    .build();
            httpGet.setURI(uri);

            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }
    }

    private static WeatherDto parsJsonToDto(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper.readValue(json, WeatherDto.class);
    }

    public static List<Weather> convertToEntity(WeatherDto weatherDto) {
        return weatherDto.getDailyForecasts().stream()
                .map(forecast -> Weather.builder()
                        .city("Saint Petersburg")
                        .date(convertToLocalDate(forecast.getDate()))
                        .minTemperature(forecast.getTemperature().getMinimum().getValue())
                        .maxTemperature(forecast.getTemperature().getMaximum().getValue())
                        .build())
                .collect(Collectors.toList());
    }

    public static LocalDate convertToLocalDate(String dataStr) {
        return LocalDate.parse(dataStr, ISO_OFFSET_DATE_TIME);
    }

}
