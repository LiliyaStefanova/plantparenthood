package plantparent.client.weather;

import javax.xml.bind.JAXB;

public class WeatherConditionCodeProvider {

    private static final String weatherCodeSource = "http://www.worldweatheronline.com/feed/wwoConditionCodes.xml";

    public void getWeatherCodes(){

        try{
            WeatherCondition condition = JAXB.unmarshal(weatherCodeSource, WeatherCondition.class);
        }
        catch(Exception ex){
            ex.printStackTrace();
            //FIXME - this needs sorting out
        }


    }

}
