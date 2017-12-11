package plantparent.jdbi;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import org.skife.jdbi.v2.DBI;
import plantparent.core.utils.database.DbConnFactory;

public class DatabaseModule extends AbstractModule {

    private static final  String PP_DB = "postgresql";

    @Override
    protected void configure(){

    }

    @Provides
    @Named(PP_DB)
    public DBI getDatabaseConnection(DbConnFactory factory){
        return factory.createDBIObject(PP_DB);
    }


}
