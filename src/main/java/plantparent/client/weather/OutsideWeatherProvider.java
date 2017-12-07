package plantparent.client.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plantparent.api.ExternalConditions;
import org.joda.time.DateTime;
import plantparent.core.utils.exceptions.PlantParenthoodServiceException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

public class OutsideWeatherProvider {

    private OutsideConditionsServiceClientImpl weatherServiceClient;

    private static final Logger LOG = LoggerFactory.getLogger(OutsideWeatherProvider.class);

    @Inject
    public OutsideWeatherProvider(OutsideConditionsServiceClientImpl weatherServiceClient){
        this.weatherServiceClient = weatherServiceClient;
    }

    public ExternalConditions getOutsideWeatherConditions(String location){
        try{
            return extractExternalConditions(weatherServiceClient.getCurrentOutsideConditions(location));
        } catch(PlantParenthoodServiceException ex){
            LOG.error("Could not get current outside conditions from WoW API");
            return new ExternalConditions("N/A","N/A","N/A","N/A", Collections.<Object>emptyList(),Collections.<Object>emptyList(),
                    "N/A","N/A","N/A","N/A","N/A","N/A","N/A",
                    "N/A","N/A","N/A", "N/A");
        }

    }

    private ExternalConditions extractExternalConditions(String apiOutput){
        //TODO validation around here
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(apiOutput);
            JsonNode currentConditions = node.path("data").get("current_condition").get(0);
            LOG.info("The data node: "+ currentConditions.toString());
            return mapper.treeToValue(currentConditions, ExternalConditions.class);
        }
        catch(IOException ex){
            LOG.error("Could not parse WoW API response");
            return new ExternalConditions("N/A","N/A","N/A","N/A", Collections.<Object>emptyList(),Collections.<Object>emptyList(),
                    "N/A","N/A","N/A","N/A","N/A","N/A","N/A",
                    "N/A","N/A","N/A", "N/A");
        }

    }

}
