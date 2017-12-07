package plantparent.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import plantparent.api.ExternalConditions;
import plantparent.client.weather.OutsideWeatherProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import plantparent.core.utils.validation.ApiParameterValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public ExternalConditions getCurrentOutsideConditions(@QueryParam("location") String location){
        //TODO - handle case for location not found (this will be look up from client
        if(!ApiParameterValidator.isValidLocation(location)) {
            final String msg = String.format("Invalid location provided: ", location);
            throw new WebApplicationException(msg, Response.Status.BAD_REQUEST);
        }
        return outsideWeatherProvider.getOutsideWeatherConditions(location);

    }

}

