package plantparent.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

public class ExternalConditions {

    private DateTime observationTime;

    private String temperatureC;

    private String temperatureF;

    private String weatherCode;

    private String [] weatherIconUrl;

    private String [] weatherDesc;

    private String windspeedMiles;

    private String windspeedKmph;

    private String winddirDegree;

    private String winddir16Point;

    private String precipMM;

    private String humidity;

    private String visibility;

    private String pressure;

    private String cloudcover;

    private String feelsLikeC;

    private String FeelsLikeF;

    public ExternalConditions(DateTime observationTime, String temperatureC, String temperatureF, String weatherCode, String[] weatherIconUrl, String[] weatherDesc, String windspeedMiles, String windspeedKmph, String winddirDegree, String winddir16Point, String precipMM, String humidity, String visibility, String pressure, String cloudcover, String feelsLikeC, String feelsLikeF) {
        this.observationTime = observationTime;
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
        this.weatherCode = weatherCode;
        this.weatherIconUrl = weatherIconUrl;
        this.weatherDesc = weatherDesc;
        this.windspeedMiles = windspeedMiles;
        this.windspeedKmph = windspeedKmph;
        this.winddirDegree = winddirDegree;
        this.winddir16Point = winddir16Point;
        this.precipMM = precipMM;
        this.humidity = humidity;
        this.visibility = visibility;
        this.pressure = pressure;
        this.cloudcover = cloudcover;
        this.feelsLikeC = feelsLikeC;
        FeelsLikeF = feelsLikeF;
    }

    public ExternalConditions(){}

    @JsonProperty("observation_time")
    public DateTime getObservationTime() {
        return observationTime;
    }

    @JsonProperty("temp_C")
    public String getTemperatureC() {
        return temperatureC;
    }

    @JsonProperty("temp_F")
    public String getTemperatureF() {
        return temperatureF;
    }

    @JsonProperty
    public String getWeatherCode() {
        return weatherCode;
    }

    @JsonProperty
    public String[] getWeatherIconUrl() {
        return weatherIconUrl;
    }

    @JsonProperty
    public String[] getWeatherDesc() {
        return weatherDesc;
    }

    @JsonProperty
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    @JsonProperty
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    @JsonProperty
    public String getWinddirDegree() {
        return winddirDegree;
    }

    @JsonProperty
    public String getWinddir16Point() {
        return winddir16Point;
    }

    @JsonProperty
    public String getPrecipMM() {
        return precipMM;
    }

    @JsonProperty
    public String getHumidity() {
        return humidity;
    }

    @JsonProperty
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty
    public String getPressure() {
        return pressure;
    }

    @JsonProperty
    public String getCloudcover() {
        return cloudcover;
    }

    @JsonProperty("FeelsLikeC")
    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    @JsonProperty("FeelsLikeF")
    public String getFeelsLikeF() {
        return FeelsLikeF;
    }
}
