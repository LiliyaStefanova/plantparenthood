package plantparent.jdbi.dao;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import plantparent.api.PlantMedium;

import java.util.List;
import java.util.Optional;

public interface PlantMediumDao {

    @SqlUpdate("insert into plant-medium(id, type, composition, created_ts, updated_ts) values (:id, :type, :composition, :created_ts, :updated_ts)")
    void insert(@Bind("id") int id, @Bind("type") String type, @Bind("composition") String composition, @Bind("created_ts")DateTime created_ts,
                @Bind("updated_ts") DateTime updated_ts);

    //TODO implement an upsert if supported

    @SqlQuery("select id, type, composition from plant-medium where id = :id")
    @RegisterMapper(PlantMediumMapper.class)
    Optional<PlantMedium> getPlantMediumById(@Bind("id") int id);

    @SqlQuery("select id, type, composition from plant-medium where type =:type")
    @RegisterMapper(PlantMediumMapper.class)
    Optional<PlantMedium> getPlantMediumByType(@Bind("type") String type);

    @SqlQuery("select id, type, composition from plant-medium")
    @RegisterMapper(PlantMediumMapper.class)
    List<PlantMedium> getAllPlantMediumRecords();

}
