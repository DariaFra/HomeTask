package Lesson8;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Weather {

    private String city;
    private LocalDate date;
    private double minTemperature;
    private double maxTemperature;

}
