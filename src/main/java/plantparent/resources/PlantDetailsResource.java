package plantparent.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import plantparent.api.Plant;
import plantparent.jdbi.PlantProvider;
import plantparent.jdbi.dao.PlantDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Api("Plant details")
@Path("/plants")
public class PlantDetailsResource {

    private PlantDao plantDao;

    @Inject
    public PlantDetailsResource(PlantProvider provider){
        this.plantDao = provider.getPlantDao();
    }


    @GET
    @ApiOperation("Get plant details")
    @Timed
    @Path("/info/{id}")
    public Plant getPlantDetailsById(@PathParam("id") String id){

        return null;
    }

    @GET
    @ApiOperation("Get Plant Details")
    @Timed
    @Path("/info/{name}")
    public Plant getPlantDetailsByName(@PathParam("name") String name){
        return null;
    }



}
