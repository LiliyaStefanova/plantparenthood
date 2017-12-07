package plantparent.client.weather;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plantparent.core.utils.exceptions.PlantParenthoodServiceException;

import java.io.IOException;

public class OutsideConditionsServiceClientImpl implements OutsideConditionsServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(OutsideConditionsServiceClientImpl.class);

    private static final String q = "&q=";
    private static final String key = "?key=";
    private static final String numDays = "&num_of_days=";
    private static final String format = "&format=";

    private HttpClient httpClient;

    private OutsideConditionsConfiguration configuration;

    /**
     * Sample URL request:
     * http://api.worldweatheronline.com/premium/v1/weather.ashx?key=xxxxxxxxxxxxx&q=48.85,2.35&num_of_days=2&tp=3&format=xml
     * hard code location for the time being
     */
    @Inject
    public OutsideConditionsServiceClientImpl(@Named("HttpClientForWow") HttpClient httpClient, OutsideConditionsConfiguration configuration) {
        this.httpClient = httpClient;
        this.configuration = configuration;
    }

    public String getCurrentOutsideConditions(String location) throws PlantParenthoodServiceException {

        try {
            String url = buildQuery(location);
            HttpGet getRequest = new HttpGet(url);
            //TODO fix up the headers
            getRequest.addHeader("accept", "application/json");
            LOG.debug("The url being called looks like: " + url);
            HttpResponse response = httpClient.execute(getRequest);

            int statusLine = response.getStatusLine().getStatusCode();
            if (statusLine != HttpStatus.SC_OK) {
                throw new PlantParenthoodServiceException("Request failed with HTTP error code: " + statusLine);
            }
            HttpEntity httpEntity = response.getEntity();
            //EntityUtils.toString(httpEntity) closes the input stream - store the value
            String content = EntityUtils.toString(httpEntity);
            LOG.info("The entity returned looks like: " + content);
            return content;
        } catch (IOException ex) {
            throw new PlantParenthoodServiceException("Http call to WoW API failed");
        }

    }

    //FIXME - implement this properly using a query builder
    private String buildQuery(String location){
        return this.configuration.getApiUrl()+key+this.configuration.getApiKey()+q+location+
                numDays+this.configuration.getNumDays()+format+this.configuration.getApiResponseFormat();
    }

}
