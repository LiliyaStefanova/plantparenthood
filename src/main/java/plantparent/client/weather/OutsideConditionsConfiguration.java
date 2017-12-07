package plantparent.client.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class OutsideConditionsConfiguration {

    @NotEmpty
    private String apiUrl;

    @NotEmpty
    private String apiKey;

    @NotEmpty
    private String apiResponseFormat;

    @NotEmpty
    private String numDays;

    @JsonProperty
    public String getApiUrl(){
        return apiUrl;
    }

    @JsonProperty
    public void setApiUrl(String apiUrl){
        this.apiUrl = apiUrl;
    }

    @JsonProperty
    public String getApiKey(){
        return apiKey;
    }

    @JsonProperty
    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
    }

    @JsonProperty
    public String getApiResponseFormat(){
        return apiResponseFormat;
    }

    @JsonProperty
    public void setApiResponseFormat(String apiResponseFormat){
        this.apiResponseFormat = apiResponseFormat;
    }

    @JsonProperty
    public String getNumDays(){
        return numDays;
    }

    @JsonProperty
    public void setNumDays(String numDays){
        this.numDays = numDays;
    }


}
