package Lesson6;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemperatureData {

    @JsonProperty("Value")
    private Double value;
    @JsonProperty("Unit")
    private String unit;

}