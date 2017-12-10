package plantparent.client.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plantparent.api.ExternalConditions;
import plantparent.api.WeatherCondition;
import plantparent.core.utils.exceptions.PlantParenthoodServiceException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OutsideWeatherProvider {

    private OutsideConditionsServiceClientImpl weatherServiceClient;
    private Map<String, WeatherCondition> weatherCodes;
    private static final String weatherCodeSource = "http://www.worldweatheronline.com/feed/wwoConditionCodes.xml";


    private static final Logger LOG = LoggerFactory.getLogger(OutsideWeatherProvider.class);

    @Inject
    public OutsideWeatherProvider(OutsideConditionsServiceClientImpl weatherServiceClient) {
        this.weatherServiceClient = weatherServiceClient;
        this.weatherCodes = getWeatherConditionDescriptions();
    }

    public ExternalConditions getOutsideWeatherConditions(String location) {
        try {
            return extractExternalConditions(weatherServiceClient.getCurrentOutsideConditions(location));
        } catch (PlantParenthoodServiceException ex) {
            LOG.error("Could not get current outside conditions from WoW API");
            return new ExternalConditions("N/A", "N/A", "N/A", "N/A", Collections.<Object>emptyList(), Collections.<Object>emptyList(),
                    "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A",
                    "N/A", "N/A", "N/A", "N/A");
        }

    }

    private ExternalConditions extractExternalConditions(String apiOutput) {
        //TODO validation around here
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(apiOutput);
            JsonNode currentConditions = node.path("data").get("current_condition").get(0);
            LOG.info("The data node: " + currentConditions.toString());
            this.getWeatherConditionDescriptions();
            return mapper.treeToValue(currentConditions, ExternalConditions.class);
        } catch (IOException ex) {
            LOG.error("Could not parse WoW API response");
            return new ExternalConditions("N/A", "N/A", "N/A", "N/A", Collections.<Object>emptyList(), Collections.<Object>emptyList(),
                    "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A",
                    "N/A", "N/A", "N/A", "N/A");
        }

    }

    private Map<String, WeatherCondition> getWeatherConditionDescriptions() {

        try {
            JAXBContext context = JAXBContext.newInstance(WeatherCodes.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            WeatherCodes codes = (WeatherCodes) unmarshaller.unmarshal(new URL(weatherCodeSource));
            return createCodeToWeatherConditionMap(codes);

        } catch (IOException | JAXBException ex) {
            LOG.warn("Unable to get weather description data");
            return Collections.emptyMap();
        }


    }

    private Map<String, WeatherCondition> createCodeToWeatherConditionMap(WeatherCodes codes) {

        if (codes == null || codes.getWeatherCodes().isEmpty()) return Collections.emptyMap();

        return codes.getWeatherCodes()
                .stream()
                .collect(Collectors.toMap(WeatherCondition::getCode, Function.identity()));
    }

}
