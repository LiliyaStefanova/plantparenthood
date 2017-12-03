import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.apache.http.client.HttpClient;
import resources.ExternalConditionsResource;
import weather.OutsideWeatherProvider;
import weather.OutsideWeatherServiceClient;

public class PlantParenthoodApplication extends Application<PlantParenthoodConfiguration> {

    public static void main(String [] args) throws Exception{
        new PlantParenthoodApplication().run(args);
    }

    public void initialize(Bootstrap<PlantParenthoodConfiguration> bootstrap){
//        bootstrap.addBundle(new SwaggerBundle<PlantParenthoodConfiguration>() {
//
//            @Override
//            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(PlantParenthoodConfiguration configuration){
//                return configuration.swaggerBundleConfiguration;
//            }
//        });
    }

    @Override
    public void run(PlantParenthoodConfiguration configuration, Environment environment){
        final HttpClient httpClient = new HttpClientBuilder(environment).using(configuration.getHttpClientConfiguration())
                                                                        .build(getName());
        OutsideWeatherServiceClient outsideWeatherServiceClient = new OutsideWeatherServiceClient(httpClient);
        environment.jersey().register(outsideWeatherServiceClient);
        final OutsideWeatherProvider outsideWeatherProvider  = new OutsideWeatherProvider(outsideWeatherServiceClient);
        environment.jersey().register(outsideWeatherProvider);
        final ExternalConditionsResource externalConditionsResource = new ExternalConditionsResource(outsideWeatherProvider);
        environment.jersey().register(externalConditionsResource);

    }

    @Override
    public String getName(){
        return "plant-parenthood";
    }
}
