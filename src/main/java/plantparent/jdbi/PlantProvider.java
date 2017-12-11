package plantparent.jdbi;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.skife.jdbi.v2.DBI;
import plantparent.jdbi.dao.PlantDao;

public class PlantProvider {

    private final DBI dbConn;

    @Inject
    public PlantProvider(@Named("postgresql") DBI dbConn){
        this.dbConn = dbConn;
    }

    public PlantDao getPlantDao(){
        return dbConn.onDemand(PlantDao.class);
    }
}
