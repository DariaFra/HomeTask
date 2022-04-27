package Lesson7;

import Lesson6.Temperature;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyForecast {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Temperature")
    private Temperature temperature;

}
