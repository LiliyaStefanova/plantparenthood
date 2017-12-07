package plantparent.client.weather;


import plantparent.core.utils.exceptions.PlantParenthoodServiceException;

public interface OutsideConditionsServiceClient {

    String getCurrentOutsideConditions(String location) throws PlantParenthoodServiceException;
}
