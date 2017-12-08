package plantparent.client.weather;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WeatherCondition {

    private String code;

    private String description;

    private String day_icon;

    private String night_icon;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getDay_icon() {
        return day_icon;
    }

    public String getNight_icon() {
        return night_icon;
    }

    @XmlElement
    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement
    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public void setDay_icon(String day_icon) {
        this.day_icon = day_icon;
    }

    @XmlElement
    public void setNight_icon(String night_icon) {
        this.night_icon = night_icon;
    }


}
