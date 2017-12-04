package plantparent.client.weather;

import com.google.inject.Inject;
import plantparent.api.ExternalConditions;
import org.joda.time.DateTime;

public class OutsideWeatherProvider {

    private OutsideConditionsServiceClientImpl weatherServiceClient;

    @Inject
    public OutsideWeatherProvider(OutsideConditionsServiceClientImpl weatherServiceClient){
        this.weatherServiceClient = weatherServiceClient;
    }

    public ExternalConditions getOutsideWeatherConditions(String location){
        String apiOutput = weatherServiceClient.getCurrentOutsideConditions(location);
        return new ExternalConditions(DateTime.now(), "20", "25", "100",
                "90", "1010", "dummyUrl");
    }

}
