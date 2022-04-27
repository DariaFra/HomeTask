package Lesson7;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherDto {

    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts;

}
