package plantparent;

import plantparent.client.weather.ConditionsModule;
import com.google.inject.AbstractModule;

public class PlantParenthoodModule extends AbstractModule {

    @Override
    protected void configure(){
        install(new ConditionsModule());

    }
}
