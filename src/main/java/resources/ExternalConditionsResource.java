package resources;

import com.codahale.metrics.annotation.Timed;
import weather.OutsideWeatherProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/weather/external")
@Produces(MediaType.APPLICATION_JSON)
public class ExternalConditionsResource {

    private OutsideWeatherProvider outsideWeatherProvider;

    public ExternalConditionsResource(OutsideWeatherProvider outsideWeatherProvider){
        this.outsideWeatherProvider = outsideWeatherProvider;
    }

    @GET
    @Timed
    public String getCurrentOutsideConditions(@QueryParam("location") String currentLocation){
        return "Current weather is sunny";
    }

}

