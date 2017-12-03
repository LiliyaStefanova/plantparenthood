package weather;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public class OutsideWeatherServiceClient {


    private HttpClient httpClient;
    /**
     * Sample URL request:
     * http://api.worldweatheronline.com/premium/v1/weather.ashx?key=xxxxxxxxxxxxx&q=48.85,2.35&num_of_days=2&tp=3&format=xml
     * hard code location for the time being
     */
    public OutsideWeatherServiceClient(HttpClient httpClient){
        this.httpClient = httpClient;
    }

    public String getCurrentOutsideConditions(String location){

        HttpGet httpGet = new HttpGet();
        return "";
    }

}
