package plantparent.client.weather;

import plantparent.api.WeatherCondition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "codes")
public class WeatherCodes {

    private List<WeatherCondition> weatherCodes;


    @XmlElement(name = "condition")
    public List<WeatherCondition> getWeatherCodes() {
        return weatherCodes;
    }

    public void setWeatherCodes(List<WeatherCondition> codes) {
        this.weatherCodes = codes;
    }


}
