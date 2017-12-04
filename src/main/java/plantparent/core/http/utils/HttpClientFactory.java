package plantparent.core.http.utils;

import com.google.inject.Inject;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Environment;
import org.apache.http.client.HttpClient;
import plantparent.PlantParenthoodConfiguration;

public class HttpClientFactory {

    private Environment environment;
    private PlantParenthoodConfiguration mainConfig;

    @Inject
    public HttpClientFactory(Environment environment, PlantParenthoodConfiguration configuration){
        this.environment = environment;
        this.mainConfig = configuration;
    }

    //FIXME sort out authentication and other headers
    public HttpClient createClient(String name){
        return new HttpClientBuilder(environment)
                        .using(mainConfig.getHttpClientConfiguration())
                        .build(name);
    }
}
