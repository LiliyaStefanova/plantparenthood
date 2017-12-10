package plantparent.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="condition")
public class WeatherCondition {

    private String code;

    private String description;

    private String day_icon;

    private String night_icon;

    @XmlElement(name = "code")
    public String getCode() {
        return code;
    }

    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    @XmlElement(name = "day_icon")
    public String getDay_icon() {
        return day_icon;
    }

    @XmlElement(name="night_icon")
    public String getNight_icon() {
        return night_icon;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setDay_icon(String day_icon) {
        this.day_icon = day_icon;
    }


    public void setNight_icon(String night_icon) {
        this.night_icon = night_icon;
    }


}
