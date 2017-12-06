package plantparent.client.weather;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plantparent.api.ExternalConditions;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;

public class OutsideWeatherProvider {

    private OutsideConditionsServiceClientImpl weatherServiceClient;

    private static final Logger LOG = LoggerFactory.getLogger(OutsideWeatherProvider.class);

    @Inject
    public OutsideWeatherProvider(OutsideConditionsServiceClientImpl weatherServiceClient){
        this.weatherServiceClient = weatherServiceClient;
    }

    public ExternalConditions getOutsideWeatherConditions(String location){
        return extractExternalConditions(weatherServiceClient.getCurrentOutsideConditions(location));
    }

    private ExternalConditions extractExternalConditions(InputStream apiOutput){

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(apiOutput);
            JsonNode currentConditions = node.get("current_condition").get("0");
            return mapper.treeToValue(currentConditions, ExternalConditions.class);
        }
        catch(IOException ex){
            LOG.error("Could not parse api response");
            return new ExternalConditions(DateTime.now(),"N/A","N/A","N/A",new String[]{""},new String[]{""},
                    "N/A","N/A","N/A","N/A","N/A","N/A","N/A",
                    "N/A","N/A","N/A", "N/A");
        }

    }

}
