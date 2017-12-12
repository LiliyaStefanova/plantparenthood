package plantparent;

import io.dropwizard.Application;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class PlantParenthoodApplication extends Application<PlantParenthoodConfiguration> {

    public static void main(String [] args) throws Exception{
        new PlantParenthoodApplication().run(args);
    }

    public void initialize(Bootstrap<PlantParenthoodConfiguration> bootstrap){
        //Enable auto config searches for extensions in application package and subpackages
        //To declare multiple packages for classpath scan, specify them explicitly
        bootstrap.addBundle(GuiceBundle.builder()
                            .modules(new PlantParenthoodModule(), new DropwizardModule())
                            .enableAutoConfig(getClass().getPackage().getName())
                            .build());
        super.initialize(bootstrap);

        bootstrap.addBundle(new SwaggerBundle<PlantParenthoodConfiguration>() {

            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(PlantParenthoodConfiguration configuration){
                return configuration.getSwaggerBundleConfiguration();
            }
        });
        bootstrap.addBundle(new DBIExceptionsBundle());

    }

    @Override
    public void run(PlantParenthoodConfiguration configuration, Environment environment){

    }

    @Override
    public String getName(){
        return "plant-parenthood";
    }
}
