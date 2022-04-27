package Lesson7;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class Main {

    private static final String API_KEY = "D7772AuNIlTp9WV0o3l2M8reiswsu4BY";

    public static void main(String... args) throws IOException, URISyntaxException {

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
                    String json = get5dayWeather(API_KEY);
                    WeatherDto weatherDto = parsJsonToDto(json);
                    printWeatherForNDays(weatherDto, numDays);
                } else {
                    System.out.println(String.format("Unsupported value '%s'", numDays));
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number");
            }
            System.out.print(questionMessage);
        }

    }

    private static void printWeatherForNDays(WeatherDto weatherDto, int numDays) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String linePattern = "City: Saint Petersburg Day: %-10s Date: %s Min: %-5s Max: %-5s";
        for (int i = 0; i < numDays; i++) {
            DailyForecast dailyForecast = weatherDto.getDailyForecasts().get(i);
            LocalDateTime date = LocalDateTime.parse(dailyForecast.getDate(), ISO_OFFSET_DATE_TIME);
            double minTemp = dailyForecast.getTemperature().getMinimum().getValue();
            double maxTemp = dailyForecast.getTemperature().getMaximum().getValue();
            System.out.println(String.format(linePattern, date.getDayOfWeek(), date.format(formatter), minTemp, maxTemp));
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


}

