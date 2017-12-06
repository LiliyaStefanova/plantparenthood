package plantparent.client.weather;

import java.io.InputStream;

public interface OutsideConditionsServiceClient {

    InputStream getCurrentOutsideConditions(String location);
}
