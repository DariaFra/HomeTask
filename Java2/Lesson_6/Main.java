package Lesson6;
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

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class Main {

    public static void main(String... args) throws IOException, URISyntaxException {

        String apikey = "D7772AuNIlTp9WV0o3l2M8reiswsu4BY";
        String json = get5dayWeather(apikey);
        WeatherDto weatherDto = parsJsonToDto(json);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String linePattern = "Day: %-10s Date: %s Min: %-5s Max: %-5s";
        for(DailyForecast dailyForecast: weatherDto.getDailyForecasts()){
            LocalDateTime date = LocalDateTime.parse(dailyForecast.getDate(), ISO_OFFSET_DATE_TIME);
            double minTemp = dailyForecast.getTemperature().getMinimum().getValue();
            double maxTemp = dailyForecast.getTemperature().getMaximum().getValue();

            System.out.println(String.format(linePattern, date.getDayOfWeek(), date.format(formatter), minTemp, maxTemp));
        }
    }

    private static String get5dayWeather(String apikey) throws IOException, URISyntaxException {
        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212";
        try(CloseableHttpClient client = HttpClients.createDefault()) {
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
