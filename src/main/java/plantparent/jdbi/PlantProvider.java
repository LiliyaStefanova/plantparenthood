package plantparent.jdbi;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.skife.jdbi.v2.DBI;
import plantparent.jdbi.dao.PlantDao;

public class PlantProvider {

    private final DBI database;

    @Inject
    public PlantProvider(@Named("postgresql") DBI dbConn){
        this.database = dbConn;
    }

    public PlantDao getPlantDao(){
        return database.onDemand(PlantDao.class);
    }
}
