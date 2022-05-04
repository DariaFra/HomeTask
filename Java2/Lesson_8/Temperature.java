package Lesson8;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Temperature {

    @JsonProperty("Minimum")
    private Lesson6.TemperatureData minimum;
    @JsonProperty("Maximum")
    private TemperatureData maximum;

}
