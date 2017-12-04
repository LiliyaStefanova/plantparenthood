package plantparent.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import plantparent.api.ExternalConditions;
import plantparent.client.weather.OutsideWeatherProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Api(value="Outside Conditions")
@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
public class ExternalConditionsResource {

    private OutsideWeatherProvider outsideWeatherProvider;

    @Inject
    public ExternalConditionsResource(OutsideWeatherProvider outsideWeatherProvider){
        this.outsideWeatherProvider = outsideWeatherProvider;
    }

    @GET
    @ApiOperation("Current external weather conditions for given location")
    @Path("/external")
    @Timed
    public ExternalConditions getCurrentOutsideConditions(@QueryParam("location") String currentLocation){
        //TODO set this up to come back as a response and not a POJO
        return outsideWeatherProvider.getOutsideWeatherConditions(currentLocation);

    }

}

