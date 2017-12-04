package plantparent.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class ExternalConditions {

    private DateTime observationTime;

    private String temperatureC;

    private String windSpeedKmph;

    private String precipMills;

    private String humidity;

    private String pressure;

    private String weatherIconUrl;

    public ExternalConditions(){

    }

    public ExternalConditions(DateTime observationTime, String temperatureC, String windSpeedKmph, String precipMills,
                              String humidity, String pressure, String weatherIconUrl){
        this.observationTime = observationTime;
        this.temperatureC = temperatureC;
        this.windSpeedKmph = windSpeedKmph;
        this.precipMills  = precipMills;
        this.humidity = humidity;
        this.pressure = pressure;
        this.weatherIconUrl = weatherIconUrl;
    }

    @JsonProperty
    public DateTime getObservationTime() {
        return observationTime;
    }

    @JsonProperty
    public String getTemperatureC() {
        return temperatureC;
    }

    @JsonProperty
    public String getWindSpeedKmph() {
        return windSpeedKmph;
    }

    @JsonProperty
    public String getPrecipMills() {
        return precipMills;
    }

    @JsonProperty
    public String getHumidity() {
        return humidity;
    }

    @JsonProperty
    public String getPressure() {
        return pressure;
    }

    @JsonProperty
    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }
}
