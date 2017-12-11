package plantparent;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import plantparent.client.weather.OutsideConditionsConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PlantParenthoodConfiguration extends Configuration {

    @Valid
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @Valid
    private HttpClientConfiguration httpClient = new HttpClientConfiguration();

    @Valid
    private OutsideConditionsConfiguration weatherConfig = new OutsideConditionsConfiguration();

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

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

    @JsonProperty("database")
    public DataSourceFactory getDatabaseSourceFactory(){
        return database;
    }

    @JsonProperty("database")
    public void setDatabaseSourceFactory(DataSourceFactory configuration){
        this.database = configuration;
    }

}
