package plantparent.jdbi;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.skife.jdbi.v2.DBI;
import plantparent.jdbi.dao.PlantMediumDao;

public class PlantMediumDaoProvider {

    //FIXME - create a DAO Provider factory
    private DBI database;

    //FIXME - should DBI be a singleton ?
    @Inject
    public PlantMediumDaoProvider(@Named("postgresql") DBI dbConn){

        this.database = dbConn;
    }

    public PlantMediumDao getPlantMediumDao(){
        return database.onDemand(PlantMediumDao.class);
    }
}
