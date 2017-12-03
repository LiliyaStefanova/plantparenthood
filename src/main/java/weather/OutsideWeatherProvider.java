package weather;

public class OutsideWeatherProvider {

    private OutsideWeatherServiceClient weatherServiceClient;

    public OutsideWeatherProvider(OutsideWeatherServiceClient weatherServiceClient){
        this.weatherServiceClient = weatherServiceClient;
    }


}
