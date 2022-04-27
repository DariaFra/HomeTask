package Lesson7;

import Lesson6.TemperatureData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Temperature {

    @JsonProperty("Minimum")
    private TemperatureData minimum;
    @JsonProperty("Maximum")
    private TemperatureData maximum;

}
