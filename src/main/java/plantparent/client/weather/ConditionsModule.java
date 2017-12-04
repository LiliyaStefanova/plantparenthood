package plantparent.client.weather;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import org.apache.http.client.HttpClient;
import plantparent.PlantParenthoodConfiguration;
import plantparent.core.http.utils.HttpClientFactory;

public class ConditionsModule extends AbstractModule {

    static final String OutsideConditionsApiClient = "HttpClientForWow";

    @Override
    protected void configure() {
        bind(OutsideConditionsServiceClient.class).to(OutsideConditionsServiceClientImpl.class);
    }

    @Provides
    @Singleton
    @Named(OutsideConditionsApiClient)
    public HttpClient getOutsideCondHttpClient(HttpClientFactory clientFactory){
        return clientFactory.createClient(OutsideConditionsApiClient);
    }

    @Provides
    public OutsideConditionsConfiguration getConditionsConfiguration(PlantParenthoodConfiguration mainConfig){
        return mainConfig.getWeatherConfig();
    }
}
