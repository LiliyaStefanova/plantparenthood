package plantparent;

import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class DropwizardModule extends DropwizardAwareModule<PlantParenthoodConfiguration> {

    @Override
    protected void configure() {
        bootstrap();
        environment();
        configuration();
        appPackage();
    }
}
