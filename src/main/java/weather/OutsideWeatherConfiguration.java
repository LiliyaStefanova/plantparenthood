package weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class OutsideWeatherConfiguration{

    @NotEmpty
    private String apiUrl;

    @NotEmpty
    private String apiKey;

    @JsonProperty
    public String getApiUrl(){
        return apiUrl;
    }

    @JsonProperty
    public String getApiKey(){
        return apiKey;
    }

}
