package plantparent;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import plantparent.client.weather.OutsideConditionsConfiguration;

import javax.validation.Valid;

public class PlantParenthoodConfiguration extends Configuration {

    @Valid
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @Valid
    private HttpClientConfiguration httpClient = new HttpClientConfiguration();

    @Valid
    private OutsideConditionsConfiguration weatherConfig = new OutsideConditionsConfiguration();

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
    public OutsideConditionsConfiguration getWeatherConfig(){
        return weatherConfig;
    }

    @JsonProperty("weather")
    public void setWeatherConfig(OutsideConditionsConfiguration weatherConfig){
        this.weatherConfig = weatherConfig;
    }

}
