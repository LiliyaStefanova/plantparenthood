package plantparent.core.utils.database;

import com.google.inject.Inject;
import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;
import plantparent.PlantParenthoodConfiguration;

public class DbConnFactory {

    private io.dropwizard.setup.Environment environment;
    private PlantParenthoodConfiguration configuration;

    @Inject
    public DbConnFactory(io.dropwizard.setup.Environment environment, PlantParenthoodConfiguration configuration){
        this.environment = environment;
        this.configuration = configuration;
    }

    public DBI createDBIObject(String name){
        final DBIFactory factory = new DBIFactory();
        return factory.build(environment, configuration.getDatabaseSourceFactory(), name);
    }
}
