package plantparent.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import plantparent.api.PlantMedium;
import plantparent.jdbi.PlantMediumDaoProvider;
import plantparent.jdbi.dao.PlantMediumDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Api(value="Planting Mediums")
@Path("/plants/medium")
@Produces(MediaType.APPLICATION_JSON)
public class PlantingMediumResource {

    private PlantMediumDaoProvider mediumDaoProvider;

    @Inject
    public PlantingMediumResource(PlantMediumDaoProvider daoProvider){
        this.mediumDaoProvider = daoProvider;
    }

    @GET
    @Path("/getMediumByType/{type}")
    @ApiOperation("Gets the medium that a plant is grown in")
    @Timed
    public PlantMedium getPlantMediumByType(@PathParam("type") String type){
        final PlantMediumDao plantMediumDao = mediumDaoProvider.getPlantMediumDao();
        Optional<PlantMedium> plantMediumOptional = plantMediumDao.getPlantMediumByType(type);
        return plantMediumOptional.orElse(null);
    }


}
