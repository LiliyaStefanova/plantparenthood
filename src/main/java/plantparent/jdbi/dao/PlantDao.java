package plantparent.jdbi.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import plantparent.api.Plant;

import java.util.List;

public interface PlantDao {

    @SqlUpdate("create table...")
    void createPlanTable();

    @SqlUpdate("insert into ...")
    void insert();

    @SqlQuery("select * from ... where id= :id")
    Plant findPlantbyId(@Bind("id") int id);

    @SqlQuery("select * from ... where name= :name")
    List<Plant> findPlantByName(@Bind("name") String name);
}
