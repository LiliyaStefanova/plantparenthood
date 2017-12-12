package plantparent.jdbi.dao;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import plantparent.api.PlantMedium;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlantMediumMapper implements ResultSetMapper<PlantMedium> {

    public PlantMedium map(int index, ResultSet r, StatementContext ctx) throws SQLException{
        return new PlantMedium(r.getInt("id"), r.getString("type"),
                r.getString("composition"));
    }
}
