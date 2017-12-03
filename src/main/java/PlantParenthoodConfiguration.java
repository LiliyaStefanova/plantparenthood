import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import weather.OutsideWeatherConfiguration;

public class PlantParenthoodConfiguration extends Configuration {


    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;


    private HttpClientConfiguration httpClient = new HttpClientConfiguration();

    private OutsideWeatherConfiguration weatherConfig = new OutsideWeatherConfiguration();

    @JsonProperty
    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }

    @JsonProperty("httpClient")
    public HttpClientConfiguration getHttpClientConfiguration(){
        return httpClient;
    }

    @JsonProperty("httpClient")
    public void setHttpClientConfiguration(HttpClientConfiguration httpClient){
        this.httpClient = httpClient;
    }

    @JsonProperty("weather")
    public OutsideWeatherConfiguration getWeatherConfig(){
        return weatherConfig;
    }

    @JsonProperty("weather")
    public void setWeatherConfig(OutsideWeatherConfiguration weatherConfig){
        this.weatherConfig = weatherConfig;
    }







}
