package plantparent.client.weather;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static plantparent.client.weather.ConditionsModule.OutsideConditionsApiClient;

public class OutsideConditionsServiceClientImpl implements OutsideConditionsServiceClient {

    private static final Logger LOG = LoggerFactory.getLogger(OutsideConditionsServiceClientImpl.class);

    private HttpClient httpClient;

    private OutsideConditionsConfiguration configuration;
    /**
     * Sample URL request:
     * http://api.worldweatheronline.com/premium/v1/weather.ashx?key=xxxxxxxxxxxxx&q=48.85,2.35&num_of_days=2&tp=3&format=xml
     * hard code location for the time being
     */
    @Inject
    public OutsideConditionsServiceClientImpl(@Named(OutsideConditionsApiClient)HttpClient httpClient, OutsideConditionsConfiguration configuration){
        this.httpClient = httpClient;
        this.configuration = configuration;
    }

    public String getCurrentOutsideConditions(String location){

        try{
        String url = this.configuration.getApiUrl();
        String key = this.configuration.getApiKey();
        String queryParams = "&format="+this.configuration.getApiResponseFormat();
        String completeUrl = url+key+"&q="+location+queryParams;

        HttpGet getRequest = new HttpGet(completeUrl);
        getRequest.addHeader("accept", "application/json");
        LOG.debug("The url being called looks like: "+ url);
        HttpResponse response = httpClient.execute(getRequest);

        if(response.getStatusLine().getStatusCode()!=200){
            throw  new RuntimeException("Request failed with HTTP error code: "+ response.getStatusLine().getStatusCode());
        }
            HttpEntity httpEntity = response.getEntity();
            LOG.info("The entity returned looks like: "+EntityUtils.toString(httpEntity));
            return EntityUtils.toString(httpEntity);

        }
        catch(IOException ex){
            //FIXME
            ex.printStackTrace();
        }

        return StringUtils.EMPTY;

    }

}
